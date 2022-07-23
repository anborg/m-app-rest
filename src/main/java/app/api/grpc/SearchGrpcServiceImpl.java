package app.api.grpc;

import access.integ.IntegService;

import io.grpc.stub.StreamObserver;
import muni.model.MuniService;
import muni.model.SearchServiceGrpc;

import javax.inject.Named;
import javax.inject.Singleton;
import io.quarkus.grpc.GrpcService;
@Singleton
@GrpcService
public class SearchGrpcServiceImpl extends SearchServiceGrpc.SearchServiceImplBase {

    @Named("integ-service")
    IntegService integSvc;

    @Override
    public void personsLike(MuniService.SearchReqPerson req, StreamObserver<MuniService.SearchRes> resObs) {
        System.out.println(req);
        resObs.onNext(MuniService.SearchRes.newBuilder().setPersonList(MuniService.PersonList.newBuilder().addAllPersons(integSvc.personsRecent())).build());
        resObs.onCompleted();
    }
}
