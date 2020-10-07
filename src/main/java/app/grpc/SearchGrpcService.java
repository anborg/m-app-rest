package app.grpc;

import app.repo.CustomerRepo;
import app.repo.mock.MockRepoImpl;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import muni.model.Model;

import muni.model.MuniService;
import muni.model.SearchServiceGrpc;

import javax.inject.Singleton;
import java.util.Objects;

@Singleton
public class SearchGrpcService extends SearchServiceGrpc.SearchServiceImplBase {

    CustomerRepo repo = new MockRepoImpl();

    @Override
    public void personById(MuniService.SearchPersonReq req, StreamObserver<MuniService.SearchPersonRes> resObs) {

        System.out.println("Search.personById " + req);
        String id = req.getPerson().getId();
        MuniService.SearchPersonRes.Builder b = MuniService.SearchPersonRes.newBuilder();
        Model.Person res = repo.personById(id);
        MuniService.SearchPersonRes out = Objects.nonNull(res)? b.addPersons(res).build() : b.build();
        resObs.onNext(out);
        resObs.onCompleted();
    }

    @Override
    public void personsSimilar(MuniService.SearchPersonReq req, StreamObserver<MuniService.SearchPersonRes> resObs) {
        System.out.println(req);
        resObs.onNext(MuniService.SearchPersonRes.newBuilder().addAllPersons(repo.personAll()).build());
        resObs.onCompleted();

    }

    @Override
    public void personsAll(Empty req, StreamObserver<MuniService.SearchPersonRes> resObs) {
        System.out.println(req);
        resObs.onNext(MuniService.SearchPersonRes.newBuilder().addAllPersons(repo.personAll()).build());
        resObs.onCompleted();
    }
}
