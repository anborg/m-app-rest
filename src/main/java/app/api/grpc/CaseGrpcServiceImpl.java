package app.api.grpc;

import app.repo.PersonRepo;
import app.repo.mock.MockRepoImpl;
import io.grpc.stub.StreamObserver;
import muni.model.CaseServiceGrpc;
import muni.model.Model;
import muni.model.MuniService;
import muni.util.MockUtil;

import javax.inject.Singleton;

@Singleton
public class CaseGrpcServiceImpl extends CaseServiceGrpc.CaseServiceImplBase {

    PersonRepo repo = new MockRepoImpl();

    @Override
    public void get(MuniService.ById req, StreamObserver<Model.Case> resObs) {
        System.out.println("case.ById " + req);
        String id = req.getId();
        Model.Case res = MockUtil.buildCase(); // //TODO handle not found
        resObs.onNext(res);
        resObs.onCompleted();
    }

    @Override
    public void create(Model.Case req, StreamObserver<Model.Case> resObs) {
        System.out.println("case.ById " + req);
        String id = req.getId();
        Model.Case res = MockUtil.buildCase(); // //TODO handle not found
        resObs.onNext(res);
        resObs.onCompleted();
    }
}
