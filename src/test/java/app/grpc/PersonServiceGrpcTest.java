package app.grpc;

import muni.model.Model;
import muni.model.MuniService;
import muni.model.PersonServiceGrpc;

import io.quarkus.grpc.runtime.annotations.GrpcService;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import javax.inject.Inject;
import static org.assertj.core.api.Assertions.assertThat;


//@QuarkusTest
public class PersonServiceGrpcTest {

  @Inject
  @GrpcService("grpc-person")
  PersonServiceGrpc.PersonServiceBlockingStub personSvc;

//  @Test
  public void getPersons() throws Exception {
    Model.Person p = personSvc.get(MuniService.ById.newBuilder().setId("1").build());
    System.out.println(p);
    assertThat(p).isNotNull();
  }
}