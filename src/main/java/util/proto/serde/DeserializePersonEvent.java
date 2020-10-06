package util.proto.serde;

import app.view.PersonEvent;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;

public class DeserializePersonEvent extends JsonDeserializer<PersonEvent> {
    final static ObjectMapper mapper = new ObjectMapper();
    @Override
    public PersonEvent deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String strObj = jsonParser.readValueAsTree().toString();
        PersonEvent req = null;
        try {
            req = mapper.readValue(strObj, PersonEvent.class);
        }catch (Exception e){
            throw new IOException(e);
        }
        return req;
    }
}