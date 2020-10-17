package util.proto.serde;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.google.protobuf.UnknownFieldSet;
import io.quarkus.jackson.ObjectMapperCustomizer;
import muni.model.Model;
import muni.model.MuniService;
import muni.util.ProtoUtil;

import javax.inject.Singleton;
import java.io.IOException;

@Singleton
public class JacksonObjectMapperCustomized implements ObjectMapperCustomizer {

    public void customize(ObjectMapper mapper) {
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        //Disabling FAIL_ON_SELFREF - will cause stack overflow - Do NOT UN-COMMENT below line
        //mapper.configure(SerializationFeature.FAIL_ON_SELF_REFERENCES, false);
//        mapper.registerModule(new DeserializeSearchRequest());
        mapper.addMixIn(UnknownFieldSet.class, UnknownFieldSetIgnoreMixIn.class);


        mapper.registerModule(deserializerModule());

    }

    private SimpleModule deserializerModule(){
        SimpleModule module = new SimpleModule();
        //input param
        module.addDeserializer(MuniService.SearchReqPerson.class, new DesSearchPersonReq());
        module.addDeserializer(MuniService.CreatePersonReq.class, new DesCreatePersonReq());
        //return param
        module.addSerializer(Model.Person.class, new SerGeneric());
        module.addSerializer(MuniService.SearchRes.class, new SerGeneric()); // ONE entry for all search REsponse.
        return module;
    }




}



@JsonIgnoreType
abstract class UnknownFieldSetIgnoreMixIn {
         /*
          InvalidDefinitionException: Direct self-reference leading to cycle (through reference chain:
          muni.model.MuniService$SearchPersonRes["unknownFields"]->com.google.protobuf.UnknownFieldSet
         */
}

//------------ Deser input parameters - from wire


class DesSearchPersonReq extends JsonDeserializer<MuniService.SearchReqPerson> {
    @Override
    public MuniService.SearchReqPerson deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String strObj = jsonParser.readValueAsTree().toString();
        MuniService.SearchReqPerson req = ProtoUtil.toProto(strObj, MuniService.SearchReqPerson.getDefaultInstance()).get();
        return req;
    }
}
class DesCreatePersonReq extends JsonDeserializer<MuniService.CreatePersonReq> {
    @Override
    public MuniService.CreatePersonReq deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String strObj = jsonParser.readValueAsTree().toString();
        MuniService.CreatePersonReq req = ProtoUtil.toProto(strObj, MuniService.CreatePersonReq.getDefaultInstance()).get();
        return req;
    }
}

//------------ Ser OUT paramters to wire - just use Generic

// and NullSerializer can be something as simple as:
class NullSerializer extends JsonSerializer<Object>{
    public void serialize(Object value, JsonGenerator jgen,SerializerProvider provider)throws IOException{
        // any JSON value you want...
        jgen.writeString("");
    }
}