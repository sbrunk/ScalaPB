import java.io.{File, PrintWriter}
import java.nio.charset.Charset
import java.nio.file.{Files, Paths}

import SchemaGenerators.CompiledSchema
import com.google.protobuf
import com.google.protobuf.{Message, TextFormat => GTextFormat}

import scalapb.{GeneratedMessage, JavaProtoSupport, TextFormat}
import org.scalatest._
import org.scalatest.prop.GeneratorDrivenPropertyChecks

import scalapb.descriptors.ScalaType
import scala.language.existentials
import scala.collection.JavaConverters._

class GeneratedCodeSpec extends PropSpec with GeneratorDrivenPropertyChecks with Matchers {
  property("min and max id are consecutive over files") {
    forAll(GraphGen.genRootNode) { node =>
      def validateMinMax(pairs: Seq[(Int, Int)]) =
        pairs.sliding(2).filter(_.size == 2).forall {
          case Seq((min1, max1), (min2, max2)) => min2 == max1 + 1 && min2 <= max2
        }
      val messageIdPairs: Seq[(Int, Int)] = node.files.flatMap { f =>
        (f.minMessageId.map((_, f.maxMessageId.get)))
      }
      val enumIdPairs: Seq[(Int, Int)] = node.files.flatMap { f =>
        (f.minEnumId.map((_, f.maxEnumId.get)))
      }
      validateMinMax(messageIdPairs) && validateMinMax(enumIdPairs)
    }
  }

  property("Java and Scala protos are equivalent") {
    forAll(SchemaGenerators.genCompiledSchema, workers(1), minSuccessful(20)) {
      schema: CompiledSchema =>
        forAll(GenData.genMessageValueInstance(schema.rootNode)) {
          case (message, messageValue) =>
            // Ascii to binary is the same.
            val messageAscii = messageValue.toAscii
            try {
              val builder = schema.javaBuilder(message)
              GTextFormat.merge(messageAscii, builder)
              val javaProto: protobuf.Message = builder.build()
              val companion                   = schema.scalaObject(message)
              val scalaProto                  = companion.fromAscii(messageValue.toAscii)
              val scalaBytes                  = scalaProto.toByteArray

              // Parsing in Scala the serialized bytes should give the same object.
              val scalaParsedFromBytes = companion.parseFrom(scalaBytes)
              scalaParsedFromBytes.toProtoString should be(scalaProto.toProtoString)
              scalaParsedFromBytes should be(scalaProto)

              // Parsing in Java the bytes serialized by Scala should give back javaProto:
              val javaProto2 = schema.javaParse(message, scalaBytes)
              javaProto2 should be(javaProto)

              // getAllFields and fromFieldsMap should return the same object
              companion.fromFieldsMap(scalaProto.getAllFields) should be(scalaProto)

              // toJavaProto, fromJava should bring back the same object.
              val javaConversions =
                companion.asInstanceOf[JavaProtoSupport[GeneratedMessage, protobuf.Message]]
              javaConversions.fromJavaProto(javaProto) should be(scalaProto)
              javaConversions.toJavaProto(scalaProto) should be(javaProto)

              def javaParse(s: String): Message = {
                val builder = schema.javaBuilder(message)
                GTextFormat.merge(TextFormat.printToString(scalaProto), builder)
                builder.build()
              }

              // String representation are not always the same since maps do not preserve
              // the order.
              val scalaAscii        = TextFormat.printToString(scalaProto)
              val scalaUnicodeAscii = TextFormat.printToUnicodeString(scalaProto)

              // Scala can parse the ASCII format generated by Java:
              companion.fromAscii(javaProto.toString) should be(scalaProto)
              companion.fromAscii(GTextFormat.printToUnicodeString(javaProto)) should be(scalaProto)

              // Scala can parse the ASCII format generated by Scala:
              companion.fromAscii(scalaAscii) should be(scalaProto)
              try {
                companion.fromAscii(scalaUnicodeAscii) should be(scalaProto)
              } catch {
                case e: Exception =>
                  Files.write(
                    Paths.get(s"/tmp/unicode.txt"),
                    scalaUnicodeAscii.getBytes(Charset.forName("UTF-8"))
                  )
                  throw e
              }

              // Java can parse the ASCII format generated by Scala:
              javaParse(scalaAscii) should be(javaProto)
              javaParse(scalaUnicodeAscii) should be(javaProto)

              // Java and Scala Descriptors have the same full names.
              // Enum and message fields have same full name references.
              companion.javaDescriptor.getFullName should be(companion.scalaDescriptor.fullName)
              companion.javaDescriptor.getFields.size should be(
                companion.scalaDescriptor.fields.size
              )
              (companion.javaDescriptor.getFields.asScala zip companion.scalaDescriptor.fields)
                .foreach {
                  case (jf, sf) =>
                    jf.getFullName should be(sf.fullName)
                    jf.getJavaType() match {
                      case com.google.protobuf.Descriptors.FieldDescriptor.JavaType.MESSAGE =>
                        jf.getMessageType().getFullName should be(
                          sf.scalaType.asInstanceOf[ScalaType.Message].descriptor.fullName
                        )
                      case com.google.protobuf.Descriptors.FieldDescriptor.JavaType.ENUM =>
                        jf.getEnumType().getFullName should be(
                          sf.scalaType.asInstanceOf[ScalaType.Enum].descriptor.fullName
                        )
                      case _ =>
                    }
                }

            } catch {
              case e: Exception =>
                println(e.printStackTrace)
                println("Message: " + message.name)
                val pw = new PrintWriter(new File("/tmp/message.ascii"))
                pw.print(messageAscii)
                pw.close()
                throw new RuntimeException(e.getMessage, e)
            }
        }
    }
  }
}