package app.grpc;

import app.repo.CustomerRepo;
import app.repo.mock.MockRepoImpl;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import muni.model.Model;

import muni.model.MuniService;
import muni.model.SearchServiceGrpc;

import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
public class SearchGrpcService extends SearchServiceGrpc.SearchServiceImplBase {

    CustomerRepo repo = new MockRepoImpl();

    @Override
    public void personById(MuniService.SearchPersonReq req, StreamObserver<MuniService.SearchPersonRes> resObs) {
        super.personById(req, resObs);
        System.out.println(req);
        String id = req.getPerson().getId();
        resObs.onNext(MuniService.SearchPersonRes.newBuilder().addPersons(repo.personById(id)).build());

        resObs.onCompleted();
    }

    @Override
    public void personsSimilar(MuniService.SearchPersonReq req, StreamObserver<MuniService.SearchPersonRes> resObs) {
        super.personsSimilar(req, resObs);
        System.out.println(req);
        resObs.onNext(MuniService.SearchPersonRes.newBuilder().addAllPersons(repo.personAll()).build());
        resObs.onCompleted();

    }

    @Override
    public void personsAll(Empty req, StreamObserver<MuniService.SearchPersonRes> resObs) {
        super.personsAll(req, resObs);
        System.out.println(req);
        resObs.onNext(MuniService.SearchPersonRes.newBuilder().addAllPersons(repo.personAll()).build());
        resObs.onCompleted();
    }
}
