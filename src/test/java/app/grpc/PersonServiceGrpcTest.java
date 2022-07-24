package app.grpc;
import app.PersonResourceTest;
import io.quarkus.grpc.GrpcClient;
import io.quarkus.test.junit.QuarkusTest;
import muni.model.Model;
import muni.model.MuniService;
import muni.model.PersonServiceGrpc;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;


@QuarkusTest
public class PersonServiceGrpcTest {
  private static Logger logger = Logger.getLogger(PersonServiceGrpcTest.class.getName());

  @Inject
  @GrpcClient("grpc-person")
  PersonServiceGrpc.PersonServiceBlockingStub personSvc;

  @Test
  public void getPersons() throws Exception {
    Model.Person p = personSvc.get(MuniService.ById.newBuilder().setId(1).build());
    logger.info(p.toString());
    assertThat(p).isNotNull();
  }
}