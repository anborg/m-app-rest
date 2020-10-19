package app.api.rest;

import com.google.protobuf.InvalidProtocolBufferException;
import io.quarkus.grpc.runtime.annotations.GrpcService;
import muni.model.CaseServiceGrpc;
import muni.model.Model;
import muni.model.MuniService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/mkapp/rest/v1")
public class CaseResource {
    @Inject
    @GrpcService("grpc-case")
    CaseServiceGrpc.CaseServiceBlockingStub caseSvc;

    @GET
    @Path("cases/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") String id) throws InvalidProtocolBufferException {
        var rpcReq = MuniService.ById.newBuilder().setId(id).build();
        Model.Case res = caseSvc.get(rpcReq);
        System.out.println(res);
        return Response.ok(res).build();
    }
}