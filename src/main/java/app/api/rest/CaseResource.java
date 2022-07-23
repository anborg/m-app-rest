package app.api.rest;

import com.google.protobuf.Empty;
import muni.model.CaseServiceGrpc;
import muni.model.Model;
import muni.model.MuniService;
import muni.util.DataQuality;
import muni.util.ProtoUtil;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;
import io.quarkus.grpc.GrpcClient;
@Path("/mkapp/rest/v1")
@Produces({MediaType.APPLICATION_JSON})
public class CaseResource {
    @Inject
    @GrpcClient("grpc-case")
    CaseServiceGrpc.CaseServiceBlockingStub caseSvc;

    @GET
    @Path("cases")
    public Response getAll()  {
        MuniService.CaseList res = caseSvc.getAll(Empty.getDefaultInstance());
        return Response.ok(res.getCasesList()).header("X-Total-Count", res.getCasesCount()).build();
    }

    @GET
    @Path("cases/{id}")
    public Response get(@PathParam("id") Long id)  {
        var rpcReq = MuniService.ById.newBuilder().setId(id).build();
        Model.Case res = caseSvc.get(rpcReq);
        System.out.println(res);
        return Response.ok(res).build();
    }
    
    @POST
    @Path("cases")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    public Response post(String req)  {
        System.out.println("POST/insert Case  req=" + req);
        Optional<Model.Case> p = ProtoUtil.toProto(req, Model.Case.getDefaultInstance());
        if (p.isPresent() && DataQuality.Case.isValidForInsert(p.get())) {
            Model.Case res = caseSvc.create(p.get());
            return Response.ok(res).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
    @PUT
    @Path("cases/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    public Response patch(@PathParam("id") Long id,String req)  {
        System.out.println("PATCH/update Case  req=" + req);
        Optional<Model.Case> opt = ProtoUtil.toProto(req, Model.Case.getDefaultInstance());
        System.out.println("PATCH/update Case  req=" + opt);
        if (opt.isPresent() && DataQuality.Case.isValidForUpdate(opt.get())) {
            Model.Case res = caseSvc.update(opt.get());
            //final String json = ProtoUtil.toJson(res); //TODO tojosn not required here?
            return Response.ok(res).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}