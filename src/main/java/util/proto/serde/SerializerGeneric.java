package util.proto.serde;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.protobuf.Message;
import com.google.protobuf.util.JsonFormat;

import java.io.IOException;

public  class SerializerGeneric extends JsonSerializer<Message> {
    @Override
    public void serialize(Message message, JsonGenerator gen, SerializerProvider serializers) throws IOException {
      //gen.writeString(JsonFormat.printer().print(message));
      gen.writeRawValue(JsonFormat.printer().print(message));
    }
  }

  /*
  Hack.

  Add this annotation on top of interface classes. see Readme

  @JsonSerialize(using = MyMessageSerializer.class)
  public  static final class Customer extends


   */