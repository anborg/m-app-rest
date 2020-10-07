package app.grpc;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import app.grpc.SearchGrpcService;
import app.repo.CustomerRepo;
import app.repo.mock.MockRepoImpl;
import com.google.protobuf.Empty;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import muni.model.Model;
import muni.model.MuniService;
import muni.model.SearchServiceGrpc;
import muni.util.MockUtil;
import muni.util.ProtoUtil;

import java.util.ArrayList;
import java.util.List;

import io.quarkus.grpc.runtime.annotations.GrpcService;
@Path("/mkapp/rest/v1")
public class CoreResource {

    @Inject
    @GrpcService("mkmgrpc") // see  properties file
    SearchServiceGrpc.SearchServiceBlockingStub searchb;
//    @Inject
//    @GrpcService("mkmapiGrpcService")
//    SearchServiceGrpc.SearchServiceFutureStub

    CustomerRepo repo = new MockRepoImpl();

    @GET
    @Path("person/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response personsAll() throws InvalidProtocolBufferException {
//        MuniService.SearchPersonRes persons = MuniService.SearchPersonRes.newBuilder().addAllPersons(repo.personAll())
//                .build();
        MuniService.SearchPersonRes persons =searchb.personsAll(Empty.getDefaultInstance());

//        System.out.println("Person like:\n" + ProtoUtil.toJson(persons));
        System.out.println(persons.getPersonsList());
        final String json = ProtoUtil.toJson(persons);
        return Response.ok(json).build();
    }

    @POST
    @Path("person/similar")
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    public Response personSimilar(MuniService.SearchPersonReq req) throws InvalidProtocolBufferException {
        System.out.println("Person like req="+ req);
        Model.Person person = MockUtil.buildPerson();
        MuniService.SearchPersonRes persons = MuniService.SearchPersonRes.newBuilder().addPersons(person).build();
        List<Model.Person> list = new ArrayList<>();
        list.add(person);

        System.out.println(persons.getPersonsList());
        //persons.getListOrBuilderList().stream().forEach(m -> jsonPrinter.appendTo( m,jsonPrinter));
        //final var json = jsonPrinter.print(persons);
        final String json = ProtoUtil.toJson(persons);
        return Response.ok(list).build();
    }

//    public String generateResponse(HelloReply reply) {
//        return String.format("%s! HelloWorldService has been called %d number of times.", reply.getMessage(), reply.getCount());
//    }
//    @Path("/blocking/{name}")
//    public String helloBlocking(@PathParam("name") String name) {
//        HelloReply reply = blockingHelloService.sayHello(HelloRequest.newBuilder().setName(name).build());
//        return generateResponse(reply);
//
//    }
}