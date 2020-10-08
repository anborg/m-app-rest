package util.proto.serde;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.protobuf.Message;
//import com.google.protobuf.util.JsonFormat;
import com.google.protobuf.Parser;
import com.google.protobuf.util.JsonFormat;
import muni.util.ProtoUtil;

import java.io.IOException;

public  class SerGeneric extends JsonSerializer<Message> {
    @Override
    public void serialize(Message message, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        System.out.println("In Serialize = " + message);
//        String json = "";
//        JsonFormat.Parser p =JsonFormat.parser();
//        p.merge(json, message.toBuilder());
//        System.out.println("To Json String = " + json);
////        gen.writeString(json);
        gen.writeRawValue(JsonFormat.printer().print(message));
    }
  }


  /*
  Hack.

  Add this annotation on top of interface classes. see Readme

  @JsonSerialize(using = MyMessageSerializer.class)
  public  static final class Customer extends


   */