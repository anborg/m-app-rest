package app.api;

import app.repo.CustomerRepo;
import app.repo.mock.MockRepoImpl;
import io.grpc.stub.StreamObserver;
import muni.model.Model;
import muni.model.MuniService;
import muni.model.PersonServiceGrpc;


import javax.inject.Singleton;

@Singleton
public class PersonGrpcService extends PersonServiceGrpc.PersonServiceImplBase {
    CustomerRepo repo = new MockRepoImpl();
    @Override
    public void create(MuniService.CreatePersonReq req, StreamObserver<Model.Person> resObs) {
//        System.out.println(req);
        final Model.Person savedPerson = repo.save(req.getPerson());
        resObs.onNext(Model.Person.newBuilder(savedPerson).build());
        resObs.onCompleted();
    }
}
