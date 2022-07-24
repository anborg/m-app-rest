package app.api.grpc;

import access.integ.IntegService;

import io.grpc.stub.StreamObserver;
import muni.model.MuniService;
import muni.model.SearchServiceGrpc;

import javax.inject.Named;
import javax.inject.Singleton;
import io.quarkus.grpc.GrpcService;

import java.util.logging.Logger;

@Singleton
@GrpcService
public class SearchGrpcServiceImpl extends SearchServiceGrpc.SearchServiceImplBase {
    private static Logger logger = Logger.getLogger(SearchGrpcServiceImpl.class.getName());
    @Named("integ-service")
    IntegService integSvc;

    @Override
    public void personsLike(MuniService.SearchReqPerson req, StreamObserver<MuniService.SearchRes> resObs) {
        logger.info(req.toString());
        resObs.onNext(MuniService.SearchRes.newBuilder().setPersonList(MuniService.PersonList.newBuilder().addAllPersons(integSvc.personsRecent())).build());
        resObs.onCompleted();
    }
}
