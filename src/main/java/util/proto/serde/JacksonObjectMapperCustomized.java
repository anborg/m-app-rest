package util.proto.serde;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.protobuf.UnknownFieldSet;
import io.quarkus.jackson.ObjectMapperCustomizer;
import javax.inject.Singleton;

@Singleton
public class JacksonObjectMapperCustomized implements ObjectMapperCustomizer {

    public void customize(ObjectMapper mapper) {
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        //Disabling FAIL_ON_SELFREF - will cause stack overflow - Do NOT UN-COMMENT below line
        //mapper.configure(SerializationFeature.FAIL_ON_SELF_REFERENCES, false);
//        mapper.registerModule(new DeserializeSearchRequest());
        mapper.addMixIn(UnknownFieldSet.class, UnknownFieldSetIgnoreMixIn.class);
    }
    @JsonIgnoreType
    private abstract class UnknownFieldSetIgnoreMixIn {
         /*
          InvalidDefinitionException: Direct self-reference leading to cycle (through reference chain:
          muni.model.MuniService$SearchPersonRes["unknownFields"]->com.google.protobuf.UnknownFieldSet
         */
    }
}

