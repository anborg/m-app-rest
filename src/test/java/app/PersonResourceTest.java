package app;

import app.api.rest.PersonResource;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import muni.model.Model.Person;
import muni.service.SubsystemService;
import muni.util.ProtoUtil;
import org.junit.jupiter.api.Test;

import javax.inject.Named;
import java.util.Optional;

import static io.restassured.RestAssured.given;

@QuarkusTest
@TestHTTPEndpoint(PersonResource.class)
public class PersonResourceTest {
    @Named("integ-service")
    SubsystemService integSvc;


//    @TestHTTPResource
//    URL url;

    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void personById() throws JsonProcessingException {
        //prepare an obj using data service
        String id = "1";
        Optional<Person> person = integSvc.person().get(id);
        final var jsonExpect = ProtoUtil.toJson(person.get());

        given().log().all()
//           .pathParam("id", id)
                .when().get("persons/" + id)
                .then()
                .statusCode(200);
        //System.out.println(jsonOut);
        //assertEquals(mapper.readTree(jsonOut), mapper.readTree(jsonExpect));
    }

}