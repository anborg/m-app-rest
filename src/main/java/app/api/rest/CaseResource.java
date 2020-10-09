package app.api.rest;

import com.google.protobuf.InvalidProtocolBufferException;
import io.quarkus.grpc.runtime.annotations.GrpcService;
import muni.model.Model;
import muni.model.MuniService;
import muni.model.PersonServiceGrpc;
import muni.model.SearchServiceGrpc;
import muni.util.ProtoUtil;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/mkapp/rest/v1")
public class CaseResource {
    @Inject
    @GrpcService("grpc-case")
    PersonServiceGrpc.PersonServiceBlockingStub caseSvc;

    @GET
    @Path("cases/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") String id) throws InvalidProtocolBufferException {
        var rpcReq = MuniService.ById.newBuilder().setId(id).build();
        Model.Person res = caseSvc.get(rpcReq);
        System.out.println(res);
        return Response.ok(res).build();
    }
}