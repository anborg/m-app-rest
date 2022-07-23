package app.grpc;
import io.quarkus.grpc.GrpcClient;
import io.quarkus.test.junit.QuarkusTest;
import muni.model.Model;
import muni.model.MuniService;
import muni.model.PersonServiceGrpc;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.assertj.core.api.Assertions.assertThat;


@QuarkusTest
public class PersonServiceGrpcTest {

  @Inject
  @GrpcClient("grpc-person")
  PersonServiceGrpc.PersonServiceBlockingStub personSvc;

  @Test
  public void getPersons() throws Exception {
    Model.Person p = personSvc.get(MuniService.ById.newBuilder().setId(1).build());
    System.out.println(p);
    assertThat(p).isNotNull();
  }
}