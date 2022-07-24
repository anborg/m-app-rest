package util.proto.serde;

import app.api.grpc.PersonGrpcServiceImpl;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.protobuf.Message;
import muni.util.ProtoUtil;

import java.io.IOException;
import java.util.Objects;
import java.util.logging.Logger;

//import com.google.protobuf.util.JsonFormat;

public class SerGeneric extends JsonSerializer<Message> {
    private static Logger logger = Logger.getLogger(SerGeneric.class.getName());
    @Override
    public void serialize(Message message, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        //logger.info("#### In SerGeneric: isIntialized=" + message.isInitialized() + ", isNullOrEmptyProto=" + Strings.isNullOrEmpty(message.toString()) + " " + message);
        //gen.writeRawValue(JsonFormat.printer().print(message));
        String jsonStr = ProtoUtil.toJson(message);
        if (Objects.nonNull(jsonStr)) {
            gen.writeRawValue(jsonStr);
        }
//        else {
//            gen.writeRawValue("");
//        }
    }
  }
/*
  Hack.

  Add this annotation on top of interface classes. see Readme

  @JsonSerialize(using = MyMessageSerializer.class)
  public  static final class Customer extends
*/