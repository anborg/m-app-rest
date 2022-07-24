package app.api.rest;

import app.api.grpc.PersonGrpcServiceImpl;
import com.google.protobuf.InvalidProtocolBufferException;
import muni.model.MuniService;
import muni.model.SearchServiceGrpc;
import muni.util.ProtoUtil;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import io.quarkus.grpc.GrpcClient;

import java.util.logging.Logger;

@Path("/mkapp/rest/v1")
public class SearchResource {
    private static Logger logger = Logger.getLogger(SearchResource.class.getName());

    @Inject
    @GrpcClient("grpc-search")
    SearchServiceGrpc.SearchServiceBlockingStub searchSvc;

    @POST
    @Path("search/persons")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    @Produces({MediaType.APPLICATION_JSON})
    public Response personsLike(String protoSearchReqPerson) throws InvalidProtocolBufferException {
        logger.info("Person like req="+ protoSearchReqPerson);
        MuniService.SearchReqPerson reqRpc = ProtoUtil.toProto(protoSearchReqPerson, MuniService.SearchReqPerson.getDefaultInstance()).get();
        MuniService.SearchRes res = searchSvc.personsLike(reqRpc);
        //final String json = ProtoUtil.toJson(res);//TODO tojosn not required here?
        return Response.ok(res).build();
    }

    @POST
    @Path("search/persons/byaddress")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    @Produces({MediaType.APPLICATION_JSON})
    public Response personAddressLike(String protoAddress) throws InvalidProtocolBufferException {
        logger.info("Person like req="+ protoAddress);
        MuniService.SearchReqPerson rpcReq = ProtoUtil.toProto(protoAddress, MuniService.SearchReqPerson.getDefaultInstance()).get();
        MuniService.SearchRes res = searchSvc.personsLike(rpcReq);
        return Response.ok(res).build();
    }
}