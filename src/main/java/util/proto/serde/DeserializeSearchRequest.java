package util.proto.serde;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import muni.model.MuniService;
import muni.util.ProtoUtil;
import java.io.IOException;

public class DeserializeSearchRequest extends JsonDeserializer<MuniService.SearchPersonReq> {
    @Override
    public MuniService.SearchPersonReq deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String strObj = jsonParser.readValueAsTree().toString();
        MuniService.SearchPersonReq req = ProtoUtil.toProto(strObj, MuniService.SearchPersonReq.getDefaultInstance());
        return req;
    }
}