package app;

import app.repo.PersonRepo;
import app.repo.mock.MockRepoImpl;
import io.quarkus.test.junit.QuarkusTest;
import muni.util.ProtoUtil;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class PersonResourceTest {
    PersonRepo repo = new MockRepoImpl();
    @Test
    public void personById() {
        String id = "1";
        final var person = repo.get(id);
        final var jsonString = ProtoUtil.toJson(person);

        given()
          .when().get("mkapp/rest/v1/persons/"+id)
          .then()
             .statusCode(200)
             .body(is(jsonString));
    }

}