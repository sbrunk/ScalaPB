// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package com.google.protobuf.api
import _root_.scalapb.internal.compat.JavaConverters._

/** Api is a light-weight descriptor for an API Interface.
  *
  * Interfaces are also described as "protocol buffer services" in some contexts,
  * such as by the "service" keyword in a .proto file, but they are different
  * from API Services, which represent a concrete implementation of an interface
  * as opposed to simply a description of methods and bindings. They are also
  * sometimes simply referred to as "APIs" in other contexts, such as the name of
  * this message itself. See https://cloud.google.com/apis/design/glossary for
  * detailed terminology.
  *
  * @param name
  *   The fully qualified name of this interface, including package name
  *   followed by the interface's simple name.
  * @param methods
  *   The methods of this interface, in unspecified order.
  * @param options
  *   Any metadata attached to the interface.
  * @param version
  *   A version string for this interface. If specified, must have the form
  *   `major-version.minor-version`, as in `1.10`. If the minor version is
  *   omitted, it defaults to zero. If the entire version field is empty, the
  *   major version is derived from the package name, as outlined below. If the
  *   field is not empty, the version in the package name will be verified to be
  *   consistent with what is provided here.
  *  
  *   The versioning schema uses [semantic
  *   versioning](http://semver.org) where the major version number
  *   indicates a breaking change and the minor version an additive,
  *   non-breaking change. Both version numbers are signals to users
  *   what to expect from different versions, and should be carefully
  *   chosen based on the product plan.
  *  
  *   The major version is also reflected in the package name of the
  *   interface, which must end in `v&lt;major-version&gt;`, as in
  *   `google.feature.v1`. For major versions 0 and 1, the suffix can
  *   be omitted. Zero major versions must only be used for
  *   experimental, non-GA interfaces.
  * @param sourceContext
  *   Source context for the protocol buffer service represented by this
  *   message.
  * @param mixins
  *   Included interfaces. See [Mixin][].
  * @param syntax
  *   The source syntax of the service.
  */
@SerialVersionUID(0L)
final case class Api(
    name: _root_.scala.Predef.String = "",
    methods: _root_.scala.Seq[com.google.protobuf.api.Method] = _root_.scala.Seq.empty,
    options: _root_.scala.Seq[com.google.protobuf.`type`.OptionProto] = _root_.scala.Seq.empty,
    version: _root_.scala.Predef.String = "",
    sourceContext: _root_.scala.Option[com.google.protobuf.source_context.SourceContext] = _root_.scala.None,
    mixins: _root_.scala.Seq[com.google.protobuf.api.Mixin] = _root_.scala.Seq.empty,
    syntax: com.google.protobuf.`type`.Syntax = com.google.protobuf.`type`.Syntax.SYNTAX_PROTO2,
    unknownFields: _root_.scalapb.UnknownFieldSet = _root_.scalapb.UnknownFieldSet.empty
    ) extends scalapb.GeneratedMessage with scalapb.lenses.Updatable[Api] {
    @transient
    private[this] var __serializedSizeCachedValue: _root_.scala.Int = 0
    private[this] def __computeSerializedValue(): _root_.scala.Int = {
      var __size = 0
      
      {
        val __value = name
        if (!__value.isEmpty) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(1, __value)
        }
      };
      methods.foreach { __item =>
        val __value = __item
        __size += 1 + _root_.com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(__value.serializedSize) + __value.serializedSize
      }
      options.foreach { __item =>
        val __value = __item
        __size += 1 + _root_.com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(__value.serializedSize) + __value.serializedSize
      }
      
      {
        val __value = version
        if (!__value.isEmpty) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(4, __value)
        }
      };
      if (sourceContext.isDefined) {
        val __value = sourceContext.get
        __size += 1 + _root_.com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(__value.serializedSize) + __value.serializedSize
      };
      mixins.foreach { __item =>
        val __value = __item
        __size += 1 + _root_.com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(__value.serializedSize) + __value.serializedSize
      }
      
      {
        val __value = syntax.value
        if (__value != 0) {
          __size += _root_.com.google.protobuf.CodedOutputStream.computeEnumSize(7, __value)
        }
      };
      __size += unknownFields.serializedSize
      __size
    }
    override def serializedSize: _root_.scala.Int = {
      var read = __serializedSizeCachedValue
      if (read == 0) {
        read = __computeSerializedValue()
        __serializedSizeCachedValue = read
      }
      read
    }
    def writeTo(`_output__`: _root_.com.google.protobuf.CodedOutputStream): _root_.scala.Unit = {
      {
        val __v = name
        if (!__v.isEmpty) {
          _output__.writeString(1, __v)
        }
      };
      methods.foreach { __v =>
        val __m = __v
        _output__.writeTag(2, 2)
        _output__.writeUInt32NoTag(__m.serializedSize)
        __m.writeTo(_output__)
      };
      options.foreach { __v =>
        val __m = __v
        _output__.writeTag(3, 2)
        _output__.writeUInt32NoTag(__m.serializedSize)
        __m.writeTo(_output__)
      };
      {
        val __v = version
        if (!__v.isEmpty) {
          _output__.writeString(4, __v)
        }
      };
      sourceContext.foreach { __v =>
        val __m = __v
        _output__.writeTag(5, 2)
        _output__.writeUInt32NoTag(__m.serializedSize)
        __m.writeTo(_output__)
      };
      mixins.foreach { __v =>
        val __m = __v
        _output__.writeTag(6, 2)
        _output__.writeUInt32NoTag(__m.serializedSize)
        __m.writeTo(_output__)
      };
      {
        val __v = syntax.value
        if (__v != 0) {
          _output__.writeEnum(7, __v)
        }
      };
      unknownFields.writeTo(_output__)
    }
    def withName(__v: _root_.scala.Predef.String): Api = copy(name = __v)
    def clearMethods = copy(methods = _root_.scala.Seq.empty)
    def addMethods(__vs: com.google.protobuf.api.Method*): Api = addAllMethods(__vs)
    def addAllMethods(__vs: Iterable[com.google.protobuf.api.Method]): Api = copy(methods = methods ++ __vs)
    def withMethods(__v: _root_.scala.Seq[com.google.protobuf.api.Method]): Api = copy(methods = __v)
    def clearOptions = copy(options = _root_.scala.Seq.empty)
    def addOptions(__vs: com.google.protobuf.`type`.OptionProto*): Api = addAllOptions(__vs)
    def addAllOptions(__vs: Iterable[com.google.protobuf.`type`.OptionProto]): Api = copy(options = options ++ __vs)
    def withOptions(__v: _root_.scala.Seq[com.google.protobuf.`type`.OptionProto]): Api = copy(options = __v)
    def withVersion(__v: _root_.scala.Predef.String): Api = copy(version = __v)
    def getSourceContext: com.google.protobuf.source_context.SourceContext = sourceContext.getOrElse(com.google.protobuf.source_context.SourceContext.defaultInstance)
    def clearSourceContext: Api = copy(sourceContext = _root_.scala.None)
    def withSourceContext(__v: com.google.protobuf.source_context.SourceContext): Api = copy(sourceContext = Option(__v))
    def clearMixins = copy(mixins = _root_.scala.Seq.empty)
    def addMixins(__vs: com.google.protobuf.api.Mixin*): Api = addAllMixins(__vs)
    def addAllMixins(__vs: Iterable[com.google.protobuf.api.Mixin]): Api = copy(mixins = mixins ++ __vs)
    def withMixins(__v: _root_.scala.Seq[com.google.protobuf.api.Mixin]): Api = copy(mixins = __v)
    def withSyntax(__v: com.google.protobuf.`type`.Syntax): Api = copy(syntax = __v)
    def withUnknownFields(__v: _root_.scalapb.UnknownFieldSet) = copy(unknownFields = __v)
    def discardUnknownFields = copy(unknownFields = _root_.scalapb.UnknownFieldSet.empty)
    def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 1 => {
          val __t = name
          if (__t != "") __t else null
        }
        case 2 => methods
        case 3 => options
        case 4 => {
          val __t = version
          if (__t != "") __t else null
        }
        case 5 => sourceContext.orNull
        case 6 => mixins
        case 7 => {
          val __t = syntax.javaValueDescriptor
          if (__t.getNumber() != 0) __t else null
        }
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => _root_.scalapb.descriptors.PString(name)
        case 2 => _root_.scalapb.descriptors.PRepeated(methods.iterator.map(_.toPMessage).toVector)
        case 3 => _root_.scalapb.descriptors.PRepeated(options.iterator.map(_.toPMessage).toVector)
        case 4 => _root_.scalapb.descriptors.PString(version)
        case 5 => sourceContext.map(_.toPMessage).getOrElse(_root_.scalapb.descriptors.PEmpty)
        case 6 => _root_.scalapb.descriptors.PRepeated(mixins.iterator.map(_.toPMessage).toVector)
        case 7 => _root_.scalapb.descriptors.PEnum(syntax.scalaValueDescriptor)
      }
    }
    def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
    def companion = com.google.protobuf.api.Api
}

object Api extends scalapb.GeneratedMessageCompanion[com.google.protobuf.api.Api] with scalapb.JavaProtoSupport[com.google.protobuf.api.Api, com.google.protobuf.Api] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[com.google.protobuf.api.Api] with scalapb.JavaProtoSupport[com.google.protobuf.api.Api, com.google.protobuf.Api] = this
  def toJavaProto(scalaPbSource: com.google.protobuf.api.Api): com.google.protobuf.Api = {
    val javaPbOut = com.google.protobuf.Api.newBuilder
    javaPbOut.setName(scalaPbSource.name)
    javaPbOut.addAllMethods(_root_.scalapb.internal.compat.toIterable(scalaPbSource.methods.iterator.map(com.google.protobuf.api.Method.toJavaProto)).asJava)
    javaPbOut.addAllOptions(_root_.scalapb.internal.compat.toIterable(scalaPbSource.options.iterator.map(com.google.protobuf.`type`.OptionProto.toJavaProto)).asJava)
    javaPbOut.setVersion(scalaPbSource.version)
    scalaPbSource.sourceContext.map(com.google.protobuf.source_context.SourceContext.toJavaProto).foreach(javaPbOut.setSourceContext)
    javaPbOut.addAllMixins(_root_.scalapb.internal.compat.toIterable(scalaPbSource.mixins.iterator.map(com.google.protobuf.api.Mixin.toJavaProto)).asJava)
    javaPbOut.setSyntaxValue(scalaPbSource.syntax.value)
    javaPbOut.build
  }
  def fromJavaProto(javaPbSource: com.google.protobuf.Api): com.google.protobuf.api.Api = com.google.protobuf.api.Api(
    name = javaPbSource.getName,
    methods = javaPbSource.getMethodsList.asScala.iterator.map(com.google.protobuf.api.Method.fromJavaProto).toSeq,
    options = javaPbSource.getOptionsList.asScala.iterator.map(com.google.protobuf.`type`.OptionProto.fromJavaProto).toSeq,
    version = javaPbSource.getVersion,
    sourceContext = if (javaPbSource.hasSourceContext) Some(com.google.protobuf.source_context.SourceContext.fromJavaProto(javaPbSource.getSourceContext)) else _root_.scala.None,
    mixins = javaPbSource.getMixinsList.asScala.iterator.map(com.google.protobuf.api.Mixin.fromJavaProto).toSeq,
    syntax = com.google.protobuf.`type`.Syntax.fromValue(javaPbSource.getSyntaxValue.intValue)
  )
  def merge(`_message__`: com.google.protobuf.api.Api, `_input__`: _root_.com.google.protobuf.CodedInputStream): com.google.protobuf.api.Api = {
    var __name = `_message__`.name
    val __methods = (_root_.scala.collection.immutable.Vector.newBuilder[com.google.protobuf.api.Method] ++= `_message__`.methods)
    val __options = (_root_.scala.collection.immutable.Vector.newBuilder[com.google.protobuf.`type`.OptionProto] ++= `_message__`.options)
    var __version = `_message__`.version
    var __sourceContext = `_message__`.sourceContext
    val __mixins = (_root_.scala.collection.immutable.Vector.newBuilder[com.google.protobuf.api.Mixin] ++= `_message__`.mixins)
    var __syntax = `_message__`.syntax
    var `_unknownFields__`: _root_.scalapb.UnknownFieldSet.Builder = null
    var _done__ = false
    while (!_done__) {
      val _tag__ = _input__.readTag()
      _tag__ match {
        case 0 => _done__ = true
        case 10 =>
          __name = _input__.readStringRequireUtf8()
        case 18 =>
          __methods += _root_.scalapb.LiteParser.readMessage(_input__, com.google.protobuf.api.Method.defaultInstance)
        case 26 =>
          __options += _root_.scalapb.LiteParser.readMessage(_input__, com.google.protobuf.`type`.OptionProto.defaultInstance)
        case 34 =>
          __version = _input__.readStringRequireUtf8()
        case 42 =>
          __sourceContext = Option(_root_.scalapb.LiteParser.readMessage(_input__, __sourceContext.getOrElse(com.google.protobuf.source_context.SourceContext.defaultInstance)))
        case 50 =>
          __mixins += _root_.scalapb.LiteParser.readMessage(_input__, com.google.protobuf.api.Mixin.defaultInstance)
        case 56 =>
          __syntax = com.google.protobuf.`type`.Syntax.fromValue(_input__.readEnum())
        case tag =>
          if (_unknownFields__ == null) {
            _unknownFields__ = new _root_.scalapb.UnknownFieldSet.Builder(_message__.unknownFields)
          }
          _unknownFields__.parseField(tag, _input__)
      }
    }
    com.google.protobuf.api.Api(
        name = __name,
        methods = __methods.result(),
        options = __options.result(),
        version = __version,
        sourceContext = __sourceContext,
        mixins = __mixins.result(),
        syntax = __syntax,
        unknownFields = if (_unknownFields__ == null) _message__.unknownFields else _unknownFields__.result()
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[com.google.protobuf.api.Api] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage eq scalaDescriptor), "FieldDescriptor does not match message type.")
      com.google.protobuf.api.Api(
        name = __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).map(_.as[_root_.scala.Predef.String]).getOrElse(""),
        methods = __fieldsMap.get(scalaDescriptor.findFieldByNumber(2).get).map(_.as[_root_.scala.Seq[com.google.protobuf.api.Method]]).getOrElse(_root_.scala.Seq.empty),
        options = __fieldsMap.get(scalaDescriptor.findFieldByNumber(3).get).map(_.as[_root_.scala.Seq[com.google.protobuf.`type`.OptionProto]]).getOrElse(_root_.scala.Seq.empty),
        version = __fieldsMap.get(scalaDescriptor.findFieldByNumber(4).get).map(_.as[_root_.scala.Predef.String]).getOrElse(""),
        sourceContext = __fieldsMap.get(scalaDescriptor.findFieldByNumber(5).get).flatMap(_.as[_root_.scala.Option[com.google.protobuf.source_context.SourceContext]]),
        mixins = __fieldsMap.get(scalaDescriptor.findFieldByNumber(6).get).map(_.as[_root_.scala.Seq[com.google.protobuf.api.Mixin]]).getOrElse(_root_.scala.Seq.empty),
        syntax = com.google.protobuf.`type`.Syntax.fromValue(__fieldsMap.get(scalaDescriptor.findFieldByNumber(7).get).map(_.as[_root_.scalapb.descriptors.EnumValueDescriptor]).getOrElse(com.google.protobuf.`type`.Syntax.SYNTAX_PROTO2.scalaValueDescriptor).number)
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = ApiProto.javaDescriptor.getMessageTypes().get(0)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = ApiProto.scalaDescriptor.messages(0)
  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[_] = {
    var __out: _root_.scalapb.GeneratedMessageCompanion[_] = null
    (__number: @_root_.scala.unchecked) match {
      case 2 => __out = com.google.protobuf.api.Method
      case 3 => __out = com.google.protobuf.`type`.OptionProto
      case 5 => __out = com.google.protobuf.source_context.SourceContext
      case 6 => __out = com.google.protobuf.api.Mixin
    }
    __out
  }
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] = Seq.empty
  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[_] = {
    (__fieldNumber: @_root_.scala.unchecked) match {
      case 7 => com.google.protobuf.`type`.Syntax
    }
  }
  lazy val defaultInstance = com.google.protobuf.api.Api(
    name = "",
    methods = _root_.scala.Seq.empty,
    options = _root_.scala.Seq.empty,
    version = "",
    sourceContext = _root_.scala.None,
    mixins = _root_.scala.Seq.empty,
    syntax = com.google.protobuf.`type`.Syntax.SYNTAX_PROTO2
  )
  implicit class ApiLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, com.google.protobuf.api.Api]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, com.google.protobuf.api.Api](_l) {
    def name: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.name)((c_, f_) => c_.copy(name = f_))
    def methods: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Seq[com.google.protobuf.api.Method]] = field(_.methods)((c_, f_) => c_.copy(methods = f_))
    def options: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Seq[com.google.protobuf.`type`.OptionProto]] = field(_.options)((c_, f_) => c_.copy(options = f_))
    def version: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.version)((c_, f_) => c_.copy(version = f_))
    def sourceContext: _root_.scalapb.lenses.Lens[UpperPB, com.google.protobuf.source_context.SourceContext] = field(_.getSourceContext)((c_, f_) => c_.copy(sourceContext = Option(f_)))
    def optionalSourceContext: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Option[com.google.protobuf.source_context.SourceContext]] = field(_.sourceContext)((c_, f_) => c_.copy(sourceContext = f_))
    def mixins: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Seq[com.google.protobuf.api.Mixin]] = field(_.mixins)((c_, f_) => c_.copy(mixins = f_))
    def syntax: _root_.scalapb.lenses.Lens[UpperPB, com.google.protobuf.`type`.Syntax] = field(_.syntax)((c_, f_) => c_.copy(syntax = f_))
  }
  final val NAME_FIELD_NUMBER = 1
  final val METHODS_FIELD_NUMBER = 2
  final val OPTIONS_FIELD_NUMBER = 3
  final val VERSION_FIELD_NUMBER = 4
  final val SOURCE_CONTEXT_FIELD_NUMBER = 5
  final val MIXINS_FIELD_NUMBER = 6
  final val SYNTAX_FIELD_NUMBER = 7
  def of(
    name: _root_.scala.Predef.String,
    methods: _root_.scala.Seq[com.google.protobuf.api.Method],
    options: _root_.scala.Seq[com.google.protobuf.`type`.OptionProto],
    version: _root_.scala.Predef.String,
    sourceContext: _root_.scala.Option[com.google.protobuf.source_context.SourceContext],
    mixins: _root_.scala.Seq[com.google.protobuf.api.Mixin],
    syntax: com.google.protobuf.`type`.Syntax
  ): _root_.com.google.protobuf.api.Api = _root_.com.google.protobuf.api.Api(
    name,
    methods,
    options,
    version,
    sourceContext,
    mixins,
    syntax
  )
  // @@protoc_insertion_point(GeneratedMessageCompanion[google.protobuf.Api])
}
