// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Signing.proto

package com.yoti.api.client.spi.remote.proto;

public final class SigningProto {
  private SigningProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface AttributeSigningOrBuilder extends
      // @@protoc_insertion_point(interface_extends:attrpubapi_v1.AttributeSigning)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string name = 1;</code>
     */
    String getName();
    /**
     * <code>string name = 1;</code>
     */
    com.google.protobuf.ByteString
        getNameBytes();

    /**
     * <code>bytes value = 2;</code>
     */
    com.google.protobuf.ByteString getValue();

    /**
     * <code>.attrpubapi_v1.ContentType content_type = 3;</code>
     */
    int getContentTypeValue();
    /**
     * <code>.attrpubapi_v1.ContentType content_type = 3;</code>
     */
    com.yoti.api.client.spi.remote.proto.ContentTypeProto.ContentType getContentType();

    /**
     * <code>bytes artifact_signature = 4;</code>
     */
    com.google.protobuf.ByteString getArtifactSignature();

    /**
     * <code>string sub_type = 5;</code>
     */
    String getSubType();
    /**
     * <code>string sub_type = 5;</code>
     */
    com.google.protobuf.ByteString
        getSubTypeBytes();

    /**
     * <code>bytes signed_time_stamp = 6;</code>
     */
    com.google.protobuf.ByteString getSignedTimeStamp();
  }
  /**
   * Protobuf type {@code attrpubapi_v1.AttributeSigning}
   */
  public  static final class AttributeSigning extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:attrpubapi_v1.AttributeSigning)
      AttributeSigningOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use AttributeSigning.newBuilder() to construct.
    private AttributeSigning(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private AttributeSigning() {
      name_ = "";
      value_ = com.google.protobuf.ByteString.EMPTY;
      contentType_ = 0;
      artifactSignature_ = com.google.protobuf.ByteString.EMPTY;
      subType_ = "";
      signedTimeStamp_ = com.google.protobuf.ByteString.EMPTY;
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private AttributeSigning(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new NullPointerException();
      }
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              String s = input.readStringRequireUtf8();

              name_ = s;
              break;
            }
            case 18: {

              value_ = input.readBytes();
              break;
            }
            case 24: {
              int rawValue = input.readEnum();

              contentType_ = rawValue;
              break;
            }
            case 34: {

              artifactSignature_ = input.readBytes();
              break;
            }
            case 42: {
              String s = input.readStringRequireUtf8();

              subType_ = s;
              break;
            }
            case 50: {

              signedTimeStamp_ = input.readBytes();
              break;
            }
            default: {
              if (!parseUnknownFieldProto3(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return SigningProto.internal_static_attrpubapi_v1_AttributeSigning_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return SigningProto.internal_static_attrpubapi_v1_AttributeSigning_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              AttributeSigning.class, Builder.class);
    }

    public static final int NAME_FIELD_NUMBER = 1;
    private volatile Object name_;
    /**
     * <code>string name = 1;</code>
     */
    public String getName() {
      Object ref = name_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        name_ = s;
        return s;
      }
    }
    /**
     * <code>string name = 1;</code>
     */
    public com.google.protobuf.ByteString
        getNameBytes() {
      Object ref = name_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        name_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int VALUE_FIELD_NUMBER = 2;
    private com.google.protobuf.ByteString value_;
    /**
     * <code>bytes value = 2;</code>
     */
    public com.google.protobuf.ByteString getValue() {
      return value_;
    }

    public static final int CONTENT_TYPE_FIELD_NUMBER = 3;
    private int contentType_;
    /**
     * <code>.attrpubapi_v1.ContentType content_type = 3;</code>
     */
    public int getContentTypeValue() {
      return contentType_;
    }
    /**
     * <code>.attrpubapi_v1.ContentType content_type = 3;</code>
     */
    public com.yoti.api.client.spi.remote.proto.ContentTypeProto.ContentType getContentType() {
      @SuppressWarnings("deprecation")
      com.yoti.api.client.spi.remote.proto.ContentTypeProto.ContentType result = com.yoti.api.client.spi.remote.proto.ContentTypeProto.ContentType.valueOf(contentType_);
      return result == null ? com.yoti.api.client.spi.remote.proto.ContentTypeProto.ContentType.UNRECOGNIZED : result;
    }

    public static final int ARTIFACT_SIGNATURE_FIELD_NUMBER = 4;
    private com.google.protobuf.ByteString artifactSignature_;
    /**
     * <code>bytes artifact_signature = 4;</code>
     */
    public com.google.protobuf.ByteString getArtifactSignature() {
      return artifactSignature_;
    }

    public static final int SUB_TYPE_FIELD_NUMBER = 5;
    private volatile Object subType_;
    /**
     * <code>string sub_type = 5;</code>
     */
    public String getSubType() {
      Object ref = subType_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        subType_ = s;
        return s;
      }
    }
    /**
     * <code>string sub_type = 5;</code>
     */
    public com.google.protobuf.ByteString
        getSubTypeBytes() {
      Object ref = subType_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        subType_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int SIGNED_TIME_STAMP_FIELD_NUMBER = 6;
    private com.google.protobuf.ByteString signedTimeStamp_;
    /**
     * <code>bytes signed_time_stamp = 6;</code>
     */
    public com.google.protobuf.ByteString getSignedTimeStamp() {
      return signedTimeStamp_;
    }

    private byte memoizedIsInitialized = -1;
    @Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (!getNameBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, name_);
      }
      if (!value_.isEmpty()) {
        output.writeBytes(2, value_);
      }
      if (contentType_ != com.yoti.api.client.spi.remote.proto.ContentTypeProto.ContentType.UNDEFINED.getNumber()) {
        output.writeEnum(3, contentType_);
      }
      if (!artifactSignature_.isEmpty()) {
        output.writeBytes(4, artifactSignature_);
      }
      if (!getSubTypeBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 5, subType_);
      }
      if (!signedTimeStamp_.isEmpty()) {
        output.writeBytes(6, signedTimeStamp_);
      }
      unknownFields.writeTo(output);
    }

    @Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getNameBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, name_);
      }
      if (!value_.isEmpty()) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(2, value_);
      }
      if (contentType_ != com.yoti.api.client.spi.remote.proto.ContentTypeProto.ContentType.UNDEFINED.getNumber()) {
        size += com.google.protobuf.CodedOutputStream
          .computeEnumSize(3, contentType_);
      }
      if (!artifactSignature_.isEmpty()) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(4, artifactSignature_);
      }
      if (!getSubTypeBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, subType_);
      }
      if (!signedTimeStamp_.isEmpty()) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(6, signedTimeStamp_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @Override
    public boolean equals(final Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof AttributeSigning)) {
        return super.equals(obj);
      }
      AttributeSigning other = (AttributeSigning) obj;

      boolean result = true;
      result = result && getName()
          .equals(other.getName());
      result = result && getValue()
          .equals(other.getValue());
      result = result && contentType_ == other.contentType_;
      result = result && getArtifactSignature()
          .equals(other.getArtifactSignature());
      result = result && getSubType()
          .equals(other.getSubType());
      result = result && getSignedTimeStamp()
          .equals(other.getSignedTimeStamp());
      result = result && unknownFields.equals(other.unknownFields);
      return result;
    }

    @Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + NAME_FIELD_NUMBER;
      hash = (53 * hash) + getName().hashCode();
      hash = (37 * hash) + VALUE_FIELD_NUMBER;
      hash = (53 * hash) + getValue().hashCode();
      hash = (37 * hash) + CONTENT_TYPE_FIELD_NUMBER;
      hash = (53 * hash) + contentType_;
      hash = (37 * hash) + ARTIFACT_SIGNATURE_FIELD_NUMBER;
      hash = (53 * hash) + getArtifactSignature().hashCode();
      hash = (37 * hash) + SUB_TYPE_FIELD_NUMBER;
      hash = (53 * hash) + getSubType().hashCode();
      hash = (37 * hash) + SIGNED_TIME_STAMP_FIELD_NUMBER;
      hash = (53 * hash) + getSignedTimeStamp().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static AttributeSigning parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static AttributeSigning parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static AttributeSigning parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static AttributeSigning parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static AttributeSigning parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static AttributeSigning parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static AttributeSigning parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static AttributeSigning parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static AttributeSigning parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static AttributeSigning parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static AttributeSigning parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static AttributeSigning parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(AttributeSigning prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override
    protected Builder newBuilderForType(
        BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code attrpubapi_v1.AttributeSigning}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:attrpubapi_v1.AttributeSigning)
        AttributeSigningOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return SigningProto.internal_static_attrpubapi_v1_AttributeSigning_descriptor;
      }

      @Override
      protected FieldAccessorTable
          internalGetFieldAccessorTable() {
        return SigningProto.internal_static_attrpubapi_v1_AttributeSigning_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                AttributeSigning.class, Builder.class);
      }

      // Construct using com.yoti.api.client.spi.remote.proto.SigningProto.AttributeSigning.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      @Override
      public Builder clear() {
        super.clear();
        name_ = "";

        value_ = com.google.protobuf.ByteString.EMPTY;

        contentType_ = 0;

        artifactSignature_ = com.google.protobuf.ByteString.EMPTY;

        subType_ = "";

        signedTimeStamp_ = com.google.protobuf.ByteString.EMPTY;

        return this;
      }

      @Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return SigningProto.internal_static_attrpubapi_v1_AttributeSigning_descriptor;
      }

      @Override
      public AttributeSigning getDefaultInstanceForType() {
        return AttributeSigning.getDefaultInstance();
      }

      @Override
      public AttributeSigning build() {
        AttributeSigning result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @Override
      public AttributeSigning buildPartial() {
        AttributeSigning result = new AttributeSigning(this);
        result.name_ = name_;
        result.value_ = value_;
        result.contentType_ = contentType_;
        result.artifactSignature_ = artifactSignature_;
        result.subType_ = subType_;
        result.signedTimeStamp_ = signedTimeStamp_;
        onBuilt();
        return result;
      }

      @Override
      public Builder clone() {
        return (Builder) super.clone();
      }
      @Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      @Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      @Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      @Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      @Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      @Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof AttributeSigning) {
          return mergeFrom((AttributeSigning)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(AttributeSigning other) {
        if (other == AttributeSigning.getDefaultInstance()) return this;
        if (!other.getName().isEmpty()) {
          name_ = other.name_;
          onChanged();
        }
        if (other.getValue() != com.google.protobuf.ByteString.EMPTY) {
          setValue(other.getValue());
        }
        if (other.contentType_ != 0) {
          setContentTypeValue(other.getContentTypeValue());
        }
        if (other.getArtifactSignature() != com.google.protobuf.ByteString.EMPTY) {
          setArtifactSignature(other.getArtifactSignature());
        }
        if (!other.getSubType().isEmpty()) {
          subType_ = other.subType_;
          onChanged();
        }
        if (other.getSignedTimeStamp() != com.google.protobuf.ByteString.EMPTY) {
          setSignedTimeStamp(other.getSignedTimeStamp());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @Override
      public final boolean isInitialized() {
        return true;
      }

      @Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        AttributeSigning parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (AttributeSigning) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private Object name_ = "";
      /**
       * <code>string name = 1;</code>
       */
      public String getName() {
        Object ref = name_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          name_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <code>string name = 1;</code>
       */
      public com.google.protobuf.ByteString
          getNameBytes() {
        Object ref = name_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          name_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string name = 1;</code>
       */
      public Builder setName(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        name_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string name = 1;</code>
       */
      public Builder clearName() {
        
        name_ = getDefaultInstance().getName();
        onChanged();
        return this;
      }
      /**
       * <code>string name = 1;</code>
       */
      public Builder setNameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        name_ = value;
        onChanged();
        return this;
      }

      private com.google.protobuf.ByteString value_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>bytes value = 2;</code>
       */
      public com.google.protobuf.ByteString getValue() {
        return value_;
      }
      /**
       * <code>bytes value = 2;</code>
       */
      public Builder setValue(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        value_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bytes value = 2;</code>
       */
      public Builder clearValue() {
        
        value_ = getDefaultInstance().getValue();
        onChanged();
        return this;
      }

      private int contentType_ = 0;
      /**
       * <code>.attrpubapi_v1.ContentType content_type = 3;</code>
       */
      public int getContentTypeValue() {
        return contentType_;
      }
      /**
       * <code>.attrpubapi_v1.ContentType content_type = 3;</code>
       */
      public Builder setContentTypeValue(int value) {
        contentType_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>.attrpubapi_v1.ContentType content_type = 3;</code>
       */
      public com.yoti.api.client.spi.remote.proto.ContentTypeProto.ContentType getContentType() {
        @SuppressWarnings("deprecation")
        com.yoti.api.client.spi.remote.proto.ContentTypeProto.ContentType result = com.yoti.api.client.spi.remote.proto.ContentTypeProto.ContentType.valueOf(contentType_);
        return result == null ? com.yoti.api.client.spi.remote.proto.ContentTypeProto.ContentType.UNRECOGNIZED : result;
      }
      /**
       * <code>.attrpubapi_v1.ContentType content_type = 3;</code>
       */
      public Builder setContentType(com.yoti.api.client.spi.remote.proto.ContentTypeProto.ContentType value) {
        if (value == null) {
          throw new NullPointerException();
        }
        
        contentType_ = value.getNumber();
        onChanged();
        return this;
      }
      /**
       * <code>.attrpubapi_v1.ContentType content_type = 3;</code>
       */
      public Builder clearContentType() {
        
        contentType_ = 0;
        onChanged();
        return this;
      }

      private com.google.protobuf.ByteString artifactSignature_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>bytes artifact_signature = 4;</code>
       */
      public com.google.protobuf.ByteString getArtifactSignature() {
        return artifactSignature_;
      }
      /**
       * <code>bytes artifact_signature = 4;</code>
       */
      public Builder setArtifactSignature(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        artifactSignature_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bytes artifact_signature = 4;</code>
       */
      public Builder clearArtifactSignature() {
        
        artifactSignature_ = getDefaultInstance().getArtifactSignature();
        onChanged();
        return this;
      }

      private Object subType_ = "";
      /**
       * <code>string sub_type = 5;</code>
       */
      public String getSubType() {
        Object ref = subType_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          subType_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <code>string sub_type = 5;</code>
       */
      public com.google.protobuf.ByteString
          getSubTypeBytes() {
        Object ref = subType_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          subType_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string sub_type = 5;</code>
       */
      public Builder setSubType(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        subType_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string sub_type = 5;</code>
       */
      public Builder clearSubType() {
        
        subType_ = getDefaultInstance().getSubType();
        onChanged();
        return this;
      }
      /**
       * <code>string sub_type = 5;</code>
       */
      public Builder setSubTypeBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        subType_ = value;
        onChanged();
        return this;
      }

      private com.google.protobuf.ByteString signedTimeStamp_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>bytes signed_time_stamp = 6;</code>
       */
      public com.google.protobuf.ByteString getSignedTimeStamp() {
        return signedTimeStamp_;
      }
      /**
       * <code>bytes signed_time_stamp = 6;</code>
       */
      public Builder setSignedTimeStamp(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        signedTimeStamp_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bytes signed_time_stamp = 6;</code>
       */
      public Builder clearSignedTimeStamp() {
        
        signedTimeStamp_ = getDefaultInstance().getSignedTimeStamp();
        onChanged();
        return this;
      }
      @Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFieldsProto3(unknownFields);
      }

      @Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:attrpubapi_v1.AttributeSigning)
    }

    // @@protoc_insertion_point(class_scope:attrpubapi_v1.AttributeSigning)
    private static final AttributeSigning DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new AttributeSigning();
    }

    public static AttributeSigning getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<AttributeSigning>
        PARSER = new com.google.protobuf.AbstractParser<AttributeSigning>() {
      @Override
      public AttributeSigning parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new AttributeSigning(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<AttributeSigning> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<AttributeSigning> getParserForType() {
      return PARSER;
    }

    @Override
    public AttributeSigning getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_attrpubapi_v1_AttributeSigning_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_attrpubapi_v1_AttributeSigning_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\rSigning.proto\022\rattrpubapi_v1\032\021ContentT" +
      "ype.proto\"\252\001\n\020AttributeSigning\022\014\n\004name\030\001" +
      " \001(\t\022\r\n\005value\030\002 \001(\014\0220\n\014content_type\030\003 \001(" +
      "\0162\032.attrpubapi_v1.ContentType\022\032\n\022artifac" +
      "t_signature\030\004 \001(\014\022\020\n\010sub_type\030\005 \001(\t\022\031\n\021s" +
      "igned_time_stamp\030\006 \001(\014Bo\n$com.yoti.api.c" +
      "lient.spi.remote.protoB\014SigningProtoZ\ryo" +
      "tiprotoattr\252\002\034Yoti.Auth.ProtoBuf.Attribu" +
      "te\312\002\nAttrpubapib\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.yoti.api.client.spi.remote.proto.ContentTypeProto.getDescriptor(),
        }, assigner);
    internal_static_attrpubapi_v1_AttributeSigning_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_attrpubapi_v1_AttributeSigning_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_attrpubapi_v1_AttributeSigning_descriptor,
        new String[] { "Name", "Value", "ContentType", "ArtifactSignature", "SubType", "SignedTimeStamp", });
    com.yoti.api.client.spi.remote.proto.ContentTypeProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
