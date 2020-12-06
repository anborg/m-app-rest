package app.api.grpc;

import access.integ.IntegService;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import muni.model.CaseServiceGrpc;
import muni.model.Model;
import muni.model.MuniService;
import muni.util.MockUtil;

import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
public class CaseGrpcServiceImpl extends CaseServiceGrpc.CaseServiceImplBase {

    @Named("integ-service")
    IntegService integSvc;

    @Override
    public void get(MuniService.ById req, StreamObserver<Model.Case> resObs) {
        System.out.println("case.ById " + req);
        Long id = req.getId();
        Model.Case res = MockUtil.buildCase(); // //TODO handle not found
        resObs.onNext(res);
        resObs.onCompleted();
    }

    @Override
    public void create(Model.Case req, StreamObserver<Model.Case> resObs) {
        System.out.println("case.ById " + req);
        Long id = req.getId();
        Model.Case res = integSvc.create(req); // //TODO handle not found
        resObs.onNext(res);
        resObs.onCompleted();
    }

    @Override
    public void update(Model.Case req, StreamObserver<Model.Case> resObs) {
        System.out.println("At grpc update: pers= "+req.getId());
        Model.Case res = integSvc.update(req);
        resObs.onNext(res);//TODO handle not found
        resObs.onCompleted();
    }

    @Override
    public void getAll(Empty req, StreamObserver<MuniService.CaseList> resObs) {
        System.out.println(req);
        resObs.onNext(MuniService.CaseList.newBuilder().addAllCases(integSvc.casesRecent()).build());
        resObs.onCompleted();
    }
}
