package app.api;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.protobuf.Empty;
import com.google.protobuf.InvalidProtocolBufferException;
import muni.model.Model;
import muni.model.MuniService;
import muni.model.PersonServiceGrpc;
import muni.model.SearchServiceGrpc;
import muni.util.ProtoUtil;

import io.quarkus.grpc.runtime.annotations.GrpcService;
@Path("/mkapp/rest/v1")
public class CoreResource {

    @Inject
//    @Named("search")
    @GrpcService("grpc-search") // see  properties file
    SearchServiceGrpc.SearchServiceBlockingStub searchSvc; //blocking = synchronous
    @Inject
//    @Named("person")
    @GrpcService("grpc-person") // see  properties file
    PersonServiceGrpc.PersonServiceBlockingStub personSvc; //blocking = synchronous


    @GET
    @Path("persons")
    @Produces(MediaType.APPLICATION_JSON)
    public Response personsAll() throws InvalidProtocolBufferException {
        MuniService.SearchPersonRes persons = searchSvc.personsAll(Empty.getDefaultInstance());
        System.out.println(persons.getPersonsList());
        final String json = ProtoUtil.toJson(persons);
        return Response.ok(persons.getPersonsList()).build();
    }

    @GET
    @Path("persons/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response personsGet(@PathParam("id") String id) throws InvalidProtocolBufferException {
        MuniService.SearchPersonRes persons = searchSvc.personsAll(Empty.getDefaultInstance());
        System.out.println(persons.getPersonsList());
        final String json = ProtoUtil.toJson(persons);
        return Response.ok(persons.getPersonsList()).build();
    }

    @POST
    @Path("persons/find")
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    public Response personSimilar(String req) throws InvalidProtocolBufferException {
        System.out.println("Person like req="+ req);
        MuniService.SearchPersonReq reqObj = ProtoUtil.toProto(req, MuniService.SearchPersonReq.getDefaultInstance());
        MuniService.SearchPersonRes res = searchSvc.personsSimilar(reqObj);
        //final String json = ProtoUtil.toJson(res);//TODO tojosn not required here?
        return Response.ok(res.getPersonsList()).build();
    }

    @POST
    @Path("persons/create")
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    public Response personCreate(String req) throws InvalidProtocolBufferException {
        System.out.println("Person like req="+ req);
        MuniService.CreatePersonReq reqObj = ProtoUtil.toProto(req, MuniService.CreatePersonReq.getDefaultInstance());
        Model.Person res = personSvc.create(reqObj);
        //final String json = ProtoUtil.toJson(res); //TODO tojosn not required here?
        return Response.ok(res).build();
    }

    @PATCH
    @Path("persons/update")
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    public Response personUpdate(String req) throws InvalidProtocolBufferException {
        System.out.println("Person like req="+ req);
        MuniService.CreatePersonReq reqObj = ProtoUtil.toProto(req, MuniService.CreatePersonReq.getDefaultInstance());
        Model.Person res = personSvc.create(reqObj);
        //final String json = ProtoUtil.toJson(res); //TODO tojosn not required here?
        return Response.ok(res).build();
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