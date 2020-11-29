package app;

import access.integ.IntegService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import muni.model.Model.Person;
import muni.util.ProtoUtil;
import org.junit.jupiter.api.Test;

import javax.inject.Named;
import java.util.List;
import java.util.Optional;

import static io.restassured.RestAssured.given;

//@QuarkusTest
//@TestHTTPEndpoint(PersonResource.class)
public class PersonResourceTest {
    @Named("integ-service")
    IntegService integSvc;


//    @TestHTTPResource
//    URL url;

    ObjectMapper mapper = new ObjectMapper();


//    @Test
    public void personAll() throws JsonProcessingException {
        //prepare an obj using data service
        List<Person> persons = integSvc.personsRecent();
        final var jsonExpect = ProtoUtil.toJsonArray(persons);

        given().log().all()
//           .pathParam("id", id)
                .when().get("persons")
                .then()
                .statusCode(200);
//        System.out.println(jsonOut);
//        assertEquals(mapper.readTree(jsonOut), mapper.readTree(jsonExpect));
    }

//    @Test
    public void personById() throws JsonProcessingException {
        //prepare an obj using data service
        String id = "1";
        Optional<Person> person = integSvc.getPerson(id);
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