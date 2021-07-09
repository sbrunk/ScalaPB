// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO2

package scalapb.options

@SerialVersionUID(0L)
final case class PreprocessorOutput(
    optionsByFile: _root_.scala.collection.immutable.Map[_root_.scala.Predef.String, scalapb.options.ScalaPbOptions] = _root_.scala.collection.immutable.Map.empty,
    unknownFields: _root_.scalapb.UnknownFieldSet = _root_.scalapb.UnknownFieldSet.empty
    ) extends scalapb.GeneratedMessage with scalapb.lenses.Updatable[PreprocessorOutput] {
    @transient
    private[this] var __serializedSizeMemoized: _root_.scala.Int = 0
    private[this] def __computeSerializedSize(): _root_.scala.Int = {
      var __size = 0
      optionsByFile.foreach { __item =>
        val __value = scalapb.options.PreprocessorOutput._typemapper_optionsByFile.toBase(__item)
        __size += 1 + _root_.com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(__value.serializedSize) + __value.serializedSize
      }
      __size += unknownFields.serializedSize
      __size
    }
    override def serializedSize: _root_.scala.Int = {
      var __size = __serializedSizeMemoized
      if (__size == 0) {
        __size = __computeSerializedSize() + 1
        __serializedSizeMemoized = __size
      }
      __size - 1
      
    }
    def writeTo(`_output__`: _root_.com.google.protobuf.CodedOutputStream): _root_.scala.Unit = {
      optionsByFile.foreach { __v =>
        val __m = scalapb.options.PreprocessorOutput._typemapper_optionsByFile.toBase(__v)
        _output__.writeTag(1, 2)
        _output__.writeUInt32NoTag(__m.serializedSize)
        __m.writeTo(_output__)
      };
      unknownFields.writeTo(_output__)
    }
    def clearOptionsByFile = copy(optionsByFile = _root_.scala.collection.immutable.Map.empty)
    def addOptionsByFile(__vs: (_root_.scala.Predef.String, scalapb.options.ScalaPbOptions) *): PreprocessorOutput = addAllOptionsByFile(__vs)
    def addAllOptionsByFile(__vs: Iterable[(_root_.scala.Predef.String, scalapb.options.ScalaPbOptions)]): PreprocessorOutput = copy(optionsByFile = optionsByFile ++ __vs)
    def withOptionsByFile(__v: _root_.scala.collection.immutable.Map[_root_.scala.Predef.String, scalapb.options.ScalaPbOptions]): PreprocessorOutput = copy(optionsByFile = __v)
    def withUnknownFields(__v: _root_.scalapb.UnknownFieldSet) = copy(unknownFields = __v)
    def discardUnknownFields = copy(unknownFields = _root_.scalapb.UnknownFieldSet.empty)
    def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 1 => optionsByFile.iterator.map(scalapb.options.PreprocessorOutput._typemapper_optionsByFile.toBase(_)).toSeq
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 1 => _root_.scalapb.descriptors.PRepeated(optionsByFile.iterator.map(scalapb.options.PreprocessorOutput._typemapper_optionsByFile.toBase(_).toPMessage).toVector)
      }
    }
    def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
    def companion: scalapb.options.PreprocessorOutput.type = scalapb.options.PreprocessorOutput
    // @@protoc_insertion_point(GeneratedMessage[scalapb.PreprocessorOutput])
}

object PreprocessorOutput extends scalapb.GeneratedMessageCompanion[scalapb.options.PreprocessorOutput] {
  implicit def messageCompanion: scalapb.GeneratedMessageCompanion[scalapb.options.PreprocessorOutput] = this
  def parseFrom(`_input__`: _root_.com.google.protobuf.CodedInputStream): scalapb.options.PreprocessorOutput = {
    val __optionsByFile: _root_.scala.collection.mutable.Builder[(_root_.scala.Predef.String, scalapb.options.ScalaPbOptions), _root_.scala.collection.immutable.Map[_root_.scala.Predef.String, scalapb.options.ScalaPbOptions]] = _root_.scala.collection.immutable.Map.newBuilder[_root_.scala.Predef.String, scalapb.options.ScalaPbOptions]
    var `_unknownFields__`: _root_.scalapb.UnknownFieldSet.Builder = null
    var _done__ = false
    while (!_done__) {
      val _tag__ = _input__.readTag()
      _tag__ match {
        case 0 => _done__ = true
        case 10 =>
          __optionsByFile += scalapb.options.PreprocessorOutput._typemapper_optionsByFile.toCustom(_root_.scalapb.LiteParser.readMessage[scalapb.options.PreprocessorOutput.OptionsByFileEntry](_input__))
        case tag =>
          if (_unknownFields__ == null) {
            _unknownFields__ = new _root_.scalapb.UnknownFieldSet.Builder()
          }
          _unknownFields__.parseField(tag, _input__)
      }
    }
    scalapb.options.PreprocessorOutput(
        optionsByFile = __optionsByFile.result(),
        unknownFields = if (_unknownFields__ == null) _root_.scalapb.UnknownFieldSet.empty else _unknownFields__.result()
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[scalapb.options.PreprocessorOutput] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage eq scalaDescriptor), "FieldDescriptor does not match message type.")
      scalapb.options.PreprocessorOutput(
        optionsByFile = __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).map(_.as[_root_.scala.Seq[scalapb.options.PreprocessorOutput.OptionsByFileEntry]]).getOrElse(_root_.scala.Seq.empty).iterator.map(scalapb.options.PreprocessorOutput._typemapper_optionsByFile.toCustom(_)).toMap
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = ScalapbProto.javaDescriptor.getMessageTypes().get(8)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = ScalapbProto.scalaDescriptor.messages(8)
  def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[_] = {
    var __out: _root_.scalapb.GeneratedMessageCompanion[_] = null
    (__number: @_root_.scala.unchecked) match {
      case 1 => __out = scalapb.options.PreprocessorOutput.OptionsByFileEntry
    }
    __out
  }
  lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] =
    Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]](
      _root_.scalapb.options.PreprocessorOutput.OptionsByFileEntry
    )
  def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[_] = throw new MatchError(__fieldNumber)
  lazy val defaultInstance = scalapb.options.PreprocessorOutput(
    optionsByFile = _root_.scala.collection.immutable.Map.empty
  )
  @SerialVersionUID(0L)
  final case class OptionsByFileEntry(
      key: _root_.scala.Option[_root_.scala.Predef.String] = _root_.scala.None,
      value: _root_.scala.Option[scalapb.options.ScalaPbOptions] = _root_.scala.None,
      unknownFields: _root_.scalapb.UnknownFieldSet = _root_.scalapb.UnknownFieldSet.empty
      ) extends scalapb.GeneratedMessage with scalapb.lenses.Updatable[OptionsByFileEntry] {
      @transient
      private[this] var __serializedSizeMemoized: _root_.scala.Int = 0
      private[this] def __computeSerializedSize(): _root_.scala.Int = {
        var __size = 0
        if (key.isDefined) {
          val __value = key.get
          __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(1, __value)
        };
        if (value.isDefined) {
          val __value = value.get
          __size += 1 + _root_.com.google.protobuf.CodedOutputStream.computeUInt32SizeNoTag(__value.serializedSize) + __value.serializedSize
        };
        __size += unknownFields.serializedSize
        __size
      }
      override def serializedSize: _root_.scala.Int = {
        var __size = __serializedSizeMemoized
        if (__size == 0) {
          __size = __computeSerializedSize() + 1
          __serializedSizeMemoized = __size
        }
        __size - 1
        
      }
      def writeTo(`_output__`: _root_.com.google.protobuf.CodedOutputStream): _root_.scala.Unit = {
        key.foreach { __v =>
          val __m = __v
          _output__.writeString(1, __m)
        };
        value.foreach { __v =>
          val __m = __v
          _output__.writeTag(2, 2)
          _output__.writeUInt32NoTag(__m.serializedSize)
          __m.writeTo(_output__)
        };
        unknownFields.writeTo(_output__)
      }
      def getKey: _root_.scala.Predef.String = key.getOrElse("")
      def clearKey: OptionsByFileEntry = copy(key = _root_.scala.None)
      def withKey(__v: _root_.scala.Predef.String): OptionsByFileEntry = copy(key = Option(__v))
      def getValue: scalapb.options.ScalaPbOptions = value.getOrElse(scalapb.options.ScalaPbOptions.defaultInstance)
      def clearValue: OptionsByFileEntry = copy(value = _root_.scala.None)
      def withValue(__v: scalapb.options.ScalaPbOptions): OptionsByFileEntry = copy(value = Option(__v))
      def withUnknownFields(__v: _root_.scalapb.UnknownFieldSet) = copy(unknownFields = __v)
      def discardUnknownFields = copy(unknownFields = _root_.scalapb.UnknownFieldSet.empty)
      def getFieldByNumber(__fieldNumber: _root_.scala.Int): _root_.scala.Any = {
        (__fieldNumber: @_root_.scala.unchecked) match {
          case 1 => key.orNull
          case 2 => value.orNull
        }
      }
      def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
        _root_.scala.Predef.require(__field.containingMessage eq companion.scalaDescriptor)
        (__field.number: @_root_.scala.unchecked) match {
          case 1 => key.map(_root_.scalapb.descriptors.PString(_)).getOrElse(_root_.scalapb.descriptors.PEmpty)
          case 2 => value.map(_.toPMessage).getOrElse(_root_.scalapb.descriptors.PEmpty)
        }
      }
      def toProtoString: _root_.scala.Predef.String = _root_.scalapb.TextFormat.printToUnicodeString(this)
      def companion: scalapb.options.PreprocessorOutput.OptionsByFileEntry.type = scalapb.options.PreprocessorOutput.OptionsByFileEntry
      // @@protoc_insertion_point(GeneratedMessage[scalapb.PreprocessorOutput.OptionsByFileEntry])
  }
  
  object OptionsByFileEntry extends scalapb.GeneratedMessageCompanion[scalapb.options.PreprocessorOutput.OptionsByFileEntry] {
    implicit def messageCompanion: scalapb.GeneratedMessageCompanion[scalapb.options.PreprocessorOutput.OptionsByFileEntry] = this
    def parseFrom(`_input__`: _root_.com.google.protobuf.CodedInputStream): scalapb.options.PreprocessorOutput.OptionsByFileEntry = {
      var __key: _root_.scala.Option[_root_.scala.Predef.String] = _root_.scala.None
      var __value: _root_.scala.Option[scalapb.options.ScalaPbOptions] = _root_.scala.None
      var `_unknownFields__`: _root_.scalapb.UnknownFieldSet.Builder = null
      var _done__ = false
      while (!_done__) {
        val _tag__ = _input__.readTag()
        _tag__ match {
          case 0 => _done__ = true
          case 10 =>
            __key = Option(_input__.readStringRequireUtf8())
          case 18 =>
            __value = Option(__value.fold(_root_.scalapb.LiteParser.readMessage[scalapb.options.ScalaPbOptions](_input__))(_root_.scalapb.LiteParser.readMessage(_input__, _)))
          case tag =>
            if (_unknownFields__ == null) {
              _unknownFields__ = new _root_.scalapb.UnknownFieldSet.Builder()
            }
            _unknownFields__.parseField(tag, _input__)
        }
      }
      scalapb.options.PreprocessorOutput.OptionsByFileEntry(
          key = __key,
          value = __value,
          unknownFields = if (_unknownFields__ == null) _root_.scalapb.UnknownFieldSet.empty else _unknownFields__.result()
      )
    }
    implicit def messageReads: _root_.scalapb.descriptors.Reads[scalapb.options.PreprocessorOutput.OptionsByFileEntry] = _root_.scalapb.descriptors.Reads{
      case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
        _root_.scala.Predef.require(__fieldsMap.keys.forall(_.containingMessage eq scalaDescriptor), "FieldDescriptor does not match message type.")
        scalapb.options.PreprocessorOutput.OptionsByFileEntry(
          key = __fieldsMap.get(scalaDescriptor.findFieldByNumber(1).get).flatMap(_.as[_root_.scala.Option[_root_.scala.Predef.String]]),
          value = __fieldsMap.get(scalaDescriptor.findFieldByNumber(2).get).flatMap(_.as[_root_.scala.Option[scalapb.options.ScalaPbOptions]])
        )
      case _ => throw new RuntimeException("Expected PMessage")
    }
    def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = scalapb.options.PreprocessorOutput.javaDescriptor.getNestedTypes().get(0)
    def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = scalapb.options.PreprocessorOutput.scalaDescriptor.nestedMessages(0)
    def messageCompanionForFieldNumber(__number: _root_.scala.Int): _root_.scalapb.GeneratedMessageCompanion[_] = {
      var __out: _root_.scalapb.GeneratedMessageCompanion[_] = null
      (__number: @_root_.scala.unchecked) match {
        case 2 => __out = scalapb.options.ScalaPbOptions
      }
      __out
    }
    lazy val nestedMessagesCompanions: Seq[_root_.scalapb.GeneratedMessageCompanion[_ <: _root_.scalapb.GeneratedMessage]] = Seq.empty
    def enumCompanionForFieldNumber(__fieldNumber: _root_.scala.Int): _root_.scalapb.GeneratedEnumCompanion[_] = throw new MatchError(__fieldNumber)
    lazy val defaultInstance = scalapb.options.PreprocessorOutput.OptionsByFileEntry(
      key = _root_.scala.None,
      value = _root_.scala.None
    )
    implicit class OptionsByFileEntryLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, scalapb.options.PreprocessorOutput.OptionsByFileEntry]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, scalapb.options.PreprocessorOutput.OptionsByFileEntry](_l) {
      def key: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Predef.String] = field(_.getKey)((c_, f_) => c_.copy(key = Option(f_)))
      def optionalKey: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Option[_root_.scala.Predef.String]] = field(_.key)((c_, f_) => c_.copy(key = f_))
      def value: _root_.scalapb.lenses.Lens[UpperPB, scalapb.options.ScalaPbOptions] = field(_.getValue)((c_, f_) => c_.copy(value = Option(f_)))
      def optionalValue: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.Option[scalapb.options.ScalaPbOptions]] = field(_.value)((c_, f_) => c_.copy(value = f_))
    }
    final val KEY_FIELD_NUMBER = 1
    final val VALUE_FIELD_NUMBER = 2
    @transient
    implicit val keyValueMapper: _root_.scalapb.TypeMapper[scalapb.options.PreprocessorOutput.OptionsByFileEntry, (_root_.scala.Predef.String, scalapb.options.ScalaPbOptions)] =
      _root_.scalapb.TypeMapper[scalapb.options.PreprocessorOutput.OptionsByFileEntry, (_root_.scala.Predef.String, scalapb.options.ScalaPbOptions)](__m => (__m.getKey, __m.getValue))(__p => scalapb.options.PreprocessorOutput.OptionsByFileEntry(Some(__p._1), Some(__p._2)))
    def of(
      key: _root_.scala.Option[_root_.scala.Predef.String],
      value: _root_.scala.Option[scalapb.options.ScalaPbOptions]
    ): _root_.scalapb.options.PreprocessorOutput.OptionsByFileEntry = _root_.scalapb.options.PreprocessorOutput.OptionsByFileEntry(
      key,
      value
    )
    // @@protoc_insertion_point(GeneratedMessageCompanion[scalapb.PreprocessorOutput.OptionsByFileEntry])
  }
  
  implicit class PreprocessorOutputLens[UpperPB](_l: _root_.scalapb.lenses.Lens[UpperPB, scalapb.options.PreprocessorOutput]) extends _root_.scalapb.lenses.ObjectLens[UpperPB, scalapb.options.PreprocessorOutput](_l) {
    def optionsByFile: _root_.scalapb.lenses.Lens[UpperPB, _root_.scala.collection.immutable.Map[_root_.scala.Predef.String, scalapb.options.ScalaPbOptions]] = field(_.optionsByFile)((c_, f_) => c_.copy(optionsByFile = f_))
  }
  final val OPTIONS_BY_FILE_FIELD_NUMBER = 1
  @transient
  private[options] val _typemapper_optionsByFile: _root_.scalapb.TypeMapper[scalapb.options.PreprocessorOutput.OptionsByFileEntry, (_root_.scala.Predef.String, scalapb.options.ScalaPbOptions)] = implicitly[_root_.scalapb.TypeMapper[scalapb.options.PreprocessorOutput.OptionsByFileEntry, (_root_.scala.Predef.String, scalapb.options.ScalaPbOptions)]]
  def of(
    optionsByFile: _root_.scala.collection.immutable.Map[_root_.scala.Predef.String, scalapb.options.ScalaPbOptions]
  ): _root_.scalapb.options.PreprocessorOutput = _root_.scalapb.options.PreprocessorOutput(
    optionsByFile
  )
  // @@protoc_insertion_point(GeneratedMessageCompanion[scalapb.PreprocessorOutput])
}
