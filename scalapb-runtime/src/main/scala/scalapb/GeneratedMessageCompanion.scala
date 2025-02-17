package scalapb

import java.io.{InputStream, OutputStream}

import com.google.protobuf.{ByteString, CodedInputStream, CodedOutputStream}
import com.google.protobuf.{Descriptors => JavaDescriptors}
import scalapb.lenses.{Lens, Updatable}

import _root_.scalapb.descriptors.{PMessage, PValue}
import scala.util.Try
import scala.annotation.nowarn

trait GeneratedEnum extends Any with Product with Serializable {
  type EnumType <: GeneratedEnum
  type RecognizedType <: EnumType

  def value: Int

  def index: Int

  def name: String

  override def toString = name

  def companion: GeneratedEnumCompanion[EnumType]

  def isUnrecognized: Boolean = false

  def javaValueDescriptor: JavaDescriptors.EnumValueDescriptor =
    companion.javaDescriptor.getValues().get(index)

  def scalaValueDescriptor: _root_.scalapb.descriptors.EnumValueDescriptor =
    companion.scalaDescriptor.values(index)

  def asRecognized: Option[RecognizedType]
}

trait UnrecognizedEnum extends GeneratedEnum {
  def name = "UNRECOGNIZED"

  def index = -1

  override def isUnrecognized: Boolean = true

  override def scalaValueDescriptor: _root_.scalapb.descriptors.EnumValueDescriptor =
    companion.scalaDescriptor.findValueByNumberCreatingIfUnknown(value)
}

trait GeneratedEnumCompanion[A <: GeneratedEnum] extends Serializable {
  type ValueType = A
  def fromValue(value: Int): A
  def fromName(name: String): Option[A] = values.find(_.name == name)
  def values: Seq[A]

  /** Returns the Java descriptors for this enum. It is recommended to use scalaDescriptors. The
    * Java descriptors are available even when Java conversions is disabled, however they are not
    * available in Scala.js or scala-native.
    */
  def javaDescriptor: com.google.protobuf.Descriptors.EnumDescriptor

  def scalaDescriptor: _root_.scalapb.descriptors.EnumDescriptor
}

trait GeneratedOneof extends Any with Product with Serializable {
  type ValueType
  def number: Int
  def isDefined: Boolean
  def isEmpty: Boolean
  def value: ValueType
  def valueOption: Option[ValueType] = if (isDefined) Some(value) else None
}

trait GeneratedOneofCompanion

trait GeneratedMessage extends Any with Product with Serializable {

  /** Serializes the message into the given coded output stream */
  def writeTo(output: CodedOutputStream): Unit

  /** Serializes the message into the given output stream */
  final def writeTo(output: OutputStream): Unit = {
    val bufferSize =
      LiteParser.preferredCodedOutputStreamBufferSize(serializedSize)
    val codedOutput: CodedOutputStream =
      CodedOutputStream.newInstance(output, bufferSize)
    writeTo(codedOutput)
    codedOutput.flush()
  }

  final def writeDelimitedTo(output: OutputStream): Unit = {
    val serialized: Int = serializedSize
    val bufferSize: Int = LiteParser.preferredCodedOutputStreamBufferSize(
      CodedOutputStream.computeUInt32SizeNoTag(serialized) + serialized
    )
    val codedOutput: CodedOutputStream =
      CodedOutputStream.newInstance(output, bufferSize)
    codedOutput.writeUInt32NoTag(serialized)
    writeTo(codedOutput)
    codedOutput.flush()
  }

  def getFieldByNumber(fieldNumber: Int): Any

  // Using a Scala field descriptor.
  def getField(field: _root_.scalapb.descriptors.FieldDescriptor): PValue

  final def toPMessage: PMessage =
    PMessage(companion.scalaDescriptor.fields.map { case f =>
      (f, getField(f))
    }.toMap)

  def companion: GeneratedMessageCompanion[?]

  /** Serializes the message and returns a byte array containing its raw bytes */
  final def toByteArray: Array[Byte] = {
    val a            = new Array[Byte](serializedSize)
    val outputStream = CodedOutputStream.newInstance(a)
    writeTo(outputStream)
    outputStream.checkNoSpaceLeft()
    a
  }

  /** Serializes the message and returns a ByteString containing its raw bytes */
  final def toByteString: ByteString = {
    val output = ByteString.newOutput(serializedSize)
    writeTo(output)
    output.close()
    output.toByteString()
  }

  def serializedSize: Int

  /** Returns a human-readable ASCII format representation of this message.
    *
    * The original message can be decoded from this format by using fromAscii on the companion
    * object.
    *
    * @return
    *   human-readable representation of this message.
    */
  def toProtoString: String
}

trait ExtendableMessage[A <: ExtendableMessage[A]] extends Updatable[A] {
  self: A =>
  def unknownFields: _root_.scalapb.UnknownFieldSet

  def extension[T](generatedExtension: GeneratedExtension[A, T]): T = generatedExtension.get(this)

  def withUnknownFields(unknownFields: _root_.scalapb.UnknownFieldSet): A

  def withExtension[T](generatedExtension: GeneratedExtension[A, T])(value: T): A =
    generatedExtension.set(value)(this)
}

object ExtendableMessage {
  def unknownFieldsLen[A <: ExtendableMessage[A]]: Lens[A, _root_.scalapb.UnknownFieldSet] =
    Lens[A, _root_.scalapb.UnknownFieldSet](_.unknownFields)((c, t) => c.withUnknownFields(t))
}

trait JavaProtoSupport[ScalaPB, JavaPB] extends Any {
  def fromJavaProto(javaProto: JavaPB): ScalaPB

  def toJavaProto(scalaProto: ScalaPB): JavaPB
}

trait GeneratedMessageCompanion[A <: GeneratedMessage] extends Serializable {
  self =>
  type ValueType = A

  /** Parses a message from a CodedInputStream. */
  def parseFrom(input: CodedInputStream): A

  def parseFrom(input: InputStream): A = parseFrom(CodedInputStream.newInstance(input))

  def parseDelimitedFrom(input: CodedInputStream): Option[A] =
    LiteParser.parseDelimitedFrom(input)(this)

  def parseDelimitedFrom(input: InputStream): Option[A] =
    LiteParser.parseDelimitedFrom(input)(this)

  // Creates a stream that parses one message at a time from the delimited input stream.
  @nowarn("cat=deprecation")
  def streamFromDelimitedInput(input: InputStream): Stream[A] = {
    val codedInputStream = CodedInputStream.newInstance(input)
    Stream.continually(parseDelimitedFrom(codedInputStream)).takeWhile(_.isDefined).map(_.get)
  }

  def parseFrom(s: Array[Byte]): A = parseFrom(CodedInputStream.newInstance(s))

  /** Merges the given message with the additional fields in the steam. */
  def merge(a: A, input: CodedInputStream): A = {
    parseFrom(a.toByteArray ++ parseFrom(input).toByteArray)
  }

  def validate(s: Array[Byte]): Try[A] = Try(parseFrom(s))

  def toByteArray(a: A): Array[Byte] = a.toByteArray

  /** Returns the Java descriptors for this message. It is recommended to use scalaDescriptors. The
    * Java descriptors are available even when Java conversions is disabled, however they are not
    * available in Scala.js or scala-native.
    */
  def javaDescriptor: com.google.protobuf.Descriptors.Descriptor

  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor

  // Companion object of all nested messages. That is, all messages that are defined directly inside this
  // message.
  def nestedMessagesCompanions: Seq[GeneratedMessageCompanion[? <: GeneratedMessage]]

  def messageReads: _root_.scalapb.descriptors.Reads[A]

  def messageCompanionForFieldNumber(field: Int): GeneratedMessageCompanion[?]

  def messageCompanionForField(
      field: JavaDescriptors.FieldDescriptor
  ): GeneratedMessageCompanion[?] = {
    require(
      field.getContainingType() == javaDescriptor,
      "FieldDescriptor does not match message type."
    )
    messageCompanionForFieldNumber(field.getNumber())
  }

  def enumCompanionForFieldNumber(field: Int): GeneratedEnumCompanion[?]

  def enumCompanionForField(field: JavaDescriptors.FieldDescriptor): GeneratedEnumCompanion[?] = {
    require(
      field.getContainingType() == javaDescriptor,
      "FieldDescriptor does not match message type."
    )
    enumCompanionForFieldNumber(field.getNumber())
  }

  // The ASCII representation is the representation returned by toProtoString. The following
  // functions allow you to convert the ASCII format back to a protocol buffer.  These
  // functions are compatible with the Java implementation in the sense that anything that
  // was generated by TextFormat.printToString can be parsed by these functions.
  def validateAscii(s: String): Either[TextFormatError, A] = TextFormat.fromAscii(this, s)

  def fromAscii(s: String): A =
    validateAscii(s).fold(t => throw new TextFormatException(t.msg), identity[A])

  def defaultInstance: A
}

abstract class GeneratedFileObject {
  def scalaDescriptor: _root_.scalapb.descriptors.FileDescriptor

  /** Returns the Java descriptors for this file. It is recommended to use scalaDescriptors. The
    * Java descriptors are available even when Java conversions is disabled, however they are not
    * available in Scala.js or scala-native.
    */
  def javaDescriptor: com.google.protobuf.Descriptors.FileDescriptor
  // Other file objects that this file depends on.
  def dependencies: Seq[GeneratedFileObject]

  // Companion object of all top-level messages
  def messagesCompanions: Seq[GeneratedMessageCompanion[? <: GeneratedMessage]]
}

trait GeneratedSealedOneof extends Any with Product with Serializable {
  type MessageType <: GeneratedMessage
  def isEmpty: Boolean
  def isDefined: Boolean
  def asMessage: MessageType
}
