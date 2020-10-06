package util.proto.serde;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import muni.model.Model;
import muni.util.ProtoUtil;

import java.io.IOException;

public class DeserializePerson extends JsonDeserializer<Model.Person> {
    @Override
    public Model.Person deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String strObj = jsonParser.readValueAsTree().toString();
        Model.Person req = ProtoUtil.toProto(strObj, Model.Person.getDefaultInstance());
        return req;
    }
}
