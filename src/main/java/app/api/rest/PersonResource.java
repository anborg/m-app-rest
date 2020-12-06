package app.api.rest;

import com.google.protobuf.Empty;
import io.quarkus.grpc.runtime.annotations.GrpcService;
import muni.model.Model;
import muni.model.MuniService;
import muni.model.PersonServiceGrpc;
import muni.util.DataQuality;
import muni.util.ProtoUtil;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/mkapp/rest/v1")
@Produces({MediaType.APPLICATION_JSON})
public class PersonResource {

    @Inject
    @GrpcService("grpc-person")
    PersonServiceGrpc.PersonServiceBlockingStub personSvc;

    @GET
    @Path("persons")
    public Response getAll()  {
        MuniService.PersonList res = personSvc.getAll(Empty.getDefaultInstance());
        return Response.ok(res.getPersonsList()).header("X-Total-Count", res.getPersonsCount()).build();
    }

    @GET
    @Path("persons/{id}")
    public Response get(@PathParam("id") Long id)  {
        var rpcReq = MuniService.ById.newBuilder().setId(id).build();
        Model.Person res = personSvc.get(rpcReq);
        System.out.println("get obj hasId="+res.hasId());
        return res.hasId() ? Response.ok(res).build() : Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Path("persons")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    public Response post(String req)  {
        System.out.println("POST/insert Person  req=" + req);
        Optional<Model.Person> opt = ProtoUtil.toProto(req, Model.Person.getDefaultInstance());
        if (opt.isPresent() && DataQuality.Person.isValidForInsert(opt.get())) {
            Model.Person res = personSvc.create(opt.get());
            return Response.ok(res).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @Path("persons/{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    public Response patch(@PathParam("id") Long id,String req)  {
        System.out.println("PATCH/update Person  req=" + req);
        Optional<Model.Person> opt = ProtoUtil.toProto(req, Model.Person.getDefaultInstance());
        System.out.println("PATCH/update Person  req=" + opt);
        if (opt.isPresent() && DataQuality.Person.isValidForUpdate(opt.get())) {
            Model.Person res = personSvc.update(opt.get());
            //final String json = ProtoUtil.toJson(res); //TODO tojosn not required here?
            return Response.ok(res).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}