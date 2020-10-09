package app.api.grpc;

import app.repo.PersonRepo;
import app.repo.mock.MockRepoImpl;
import io.grpc.stub.StreamObserver;
import muni.model.MuniService;
import muni.model.SearchServiceGrpc;

import javax.inject.Singleton;

@Singleton
public class SearchGrpcServiceImpl extends SearchServiceGrpc.SearchServiceImplBase {

    PersonRepo repo = new MockRepoImpl();

    @Override
    public void personsLike(MuniService.SearchReqPerson req, StreamObserver<MuniService.SearchRes> resObs) {
        System.out.println(req);
        resObs.onNext(MuniService.SearchRes.newBuilder().setPersonList(MuniService.PersonList.newBuilder().addAllPersons(repo.all())).build());
        resObs.onCompleted();
    }
}
