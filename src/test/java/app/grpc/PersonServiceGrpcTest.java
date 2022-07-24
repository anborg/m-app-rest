package app.grpc;
import app.PersonResourceTest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.quarkus.grpc.GrpcClient;
import io.quarkus.test.junit.QuarkusTest;
import muni.model.Model;
import muni.model.MuniService;
import muni.model.PersonServiceGrpc;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;


@QuarkusTest
public class PersonServiceGrpcTest {
  private static Logger logger = Logger.getLogger(PersonServiceGrpcTest.class.getName());

  private ManagedChannel channel;

//  @BeforeEach
//  public void init() {
//    channel = ManagedChannelBuilder.forAddress("localhost", 9001).usePlaintext().build();
//  }
//
//  @AfterEach
//  public void cleanup() throws InterruptedException {
//    channel.shutdown();
//    channel.awaitTermination(10, TimeUnit.SECONDS);
//  }

  @Inject
  @GrpcClient("grpc-person")
  PersonServiceGrpc.PersonServiceBlockingStub personSvc;

  @Test
  public void getPersons() throws Exception {
//    var personSvc = PersonServiceGrpc.newBlockingStub(channel);
    var personId = MuniService.ById.newBuilder().setId(1).build();
    Model.Person out = personSvc.get(personId);
//    logger.info(out.toString());
    assertThat(out).isNotNull();
  }
}