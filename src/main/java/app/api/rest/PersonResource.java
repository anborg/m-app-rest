package app.api.rest;

import com.google.protobuf.Empty;
import com.google.protobuf.InvalidProtocolBufferException;
import io.quarkus.grpc.runtime.annotations.GrpcService;
import muni.model.Model;
import muni.model.MuniService;
import muni.model.PersonServiceGrpc;
import muni.util.ProtoUtil;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/mkapp/rest/v1")
@Produces({MediaType.APPLICATION_JSON})
public class PersonResource {

    @Inject
    @GrpcService("grpc-person")
    PersonServiceGrpc.PersonServiceBlockingStub personSvc;
    @Inject
    @GrpcService("grpc-case")
    PersonServiceGrpc.PersonServiceBlockingStub caseSvc;

    @GET
    @Path("persons")
    public Response personsAll() throws InvalidProtocolBufferException {
        MuniService.PersonList res = personSvc.getAll(Empty.getDefaultInstance());
        System.out.println(res.getPersonsList());
        return Response.ok(res.getPersonsList()).build();
    }

    @GET
    @Path("persons/{id}")
    public Response personGet(@PathParam("id") String id) throws InvalidProtocolBufferException {
        var rpcReq = MuniService.ById.newBuilder().setId(id).build();
        Model.Person res = personSvc.get(rpcReq);
        System.out.println(res);
        return Response.ok(res).build();
    }

    @POST
    @Path("persons")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    public Response personCreate(String req) throws InvalidProtocolBufferException {
        System.out.println("Person like req="+ req);
        MuniService.CreatePersonReq reqObj = ProtoUtil.toProto(req, MuniService.CreatePersonReq.getDefaultInstance());
        Model.Person res = personSvc.create(reqObj);
        //final String json = ProtoUtil.toJson(res); //TODO tojosn not required here?
        return Response.ok(res).build();
    }

    @PATCH
    @Path("persons")
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    public Response personUpdate(String req) throws InvalidProtocolBufferException {
        Model.Person reqObj = ProtoUtil.toProto(req, Model.Person.getDefaultInstance());
        Model.Person res = personSvc.update(reqObj);
        //final String json = ProtoUtil.toJson(res); //TODO tojosn not required here?
        return Response.ok(res).build();
    }
}