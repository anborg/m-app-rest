package app.api.grpc;

import access.integ.IntegService;
import com.google.protobuf.Empty;
import integ.dao.jdbi.JdbiDbUtil;
import io.grpc.stub.StreamObserver;
import io.quarkus.grpc.GrpcService;
import muni.model.CaseServiceGrpc;
import muni.model.Model;
import muni.model.MuniService;

import javax.inject.Named;
import javax.inject.Singleton;
import java.util.Optional;
import java.util.logging.Logger;

@Singleton
@GrpcService
public class CaseGrpcServiceImpl extends CaseServiceGrpc.CaseServiceImplBase {
    private static Logger logger = Logger.getLogger(CaseGrpcServiceImpl.class.getName());

    @Named("integ-service")
    IntegService integSvc;

    @Override
    public void get(MuniService.ById req, StreamObserver<Model.Case> resObs) {
        logger.info("case.ById " + req);
        Long id = req.getId();
        Optional<Model.Case> res = integSvc.getCase(id); // //TODO handle not found
        if (res.isPresent()) {
            resObs.onNext(res.get());
        } else {
            resObs.onNext(null);
        }
        resObs.onCompleted();
    }

    @Override
    public void create(Model.Case req, StreamObserver<Model.Case> resObs) {
        logger.info("Create case.ById " + req);
        Long id = req.getId();
        Model.Case res = integSvc.create(req); // //TODO handle not found
        resObs.onNext(res);
        resObs.onCompleted();
    }

    @Override
    public void update(Model.Case req, StreamObserver<Model.Case> resObs) {
        logger.info("At grpc update: pers= "+req.getId());
        Model.Case res = integSvc.update(req);
        resObs.onNext(res);//TODO handle not found
        resObs.onCompleted();
    }

    @Override
    public void getAll(Empty req, StreamObserver<MuniService.CaseList> resObs) {
        logger.info(req.toString());
        resObs.onNext(MuniService.CaseList.newBuilder().addAllCases(integSvc.casesRecent()).build());
        resObs.onCompleted();
    }
}
