package app.api;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import app.repo.CustomerRepo;
import app.repo.mock.MockRepoImpl;
import com.google.protobuf.Empty;
import com.google.protobuf.InvalidProtocolBufferException;
import muni.model.Model;
import muni.model.MuniService;
import muni.model.SearchServiceGrpc;
import muni.util.MockUtil;
import muni.util.ProtoUtil;

import io.quarkus.grpc.runtime.annotations.GrpcService;
@Path("/mkapp/rest/v1")
public class CoreResource {

    @Inject
    @GrpcService("mkmgrpc") // see  properties file
    SearchServiceGrpc.SearchServiceBlockingStub searchb; //blocking = synchronous

    @GET
    @Path("persons/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response personsAll() throws InvalidProtocolBufferException {
        MuniService.SearchPersonRes persons =searchb.personsAll(Empty.getDefaultInstance());
        System.out.println(persons.getPersonsList());
        final String json = ProtoUtil.toJson(persons);
        return Response.ok(persons.getPersonsList()).build();
    }

    @POST
    @Path("persons/similar")
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    public Response personSimilar(String req) throws InvalidProtocolBufferException {
        System.out.println("Person like req="+ req);
        MuniService.SearchPersonReq reqObj = ProtoUtil.toProto(req, MuniService.SearchPersonReq.getDefaultInstance());
        MuniService.SearchPersonRes res = searchb.personsSimilar(reqObj);
        //final String json = ProtoUtil.toJson(res);//TODO tojosn not required here?
        return Response.ok(res.getPersonsList()).build();
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