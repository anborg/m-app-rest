package app.api.grpc;

import app.repo.PersonRepo;
import app.repo.mock.MockRepoImpl;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import muni.model.Model;
import muni.model.MuniService;
import muni.model.PersonServiceGrpc;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import javax.inject.Singleton;

@Singleton
public class PersonGrpcServiceImpl extends PersonServiceGrpc.PersonServiceImplBase {
    PersonRepo repo = new MockRepoImpl();
    @Override
    public void create(MuniService.CreatePersonReq req, StreamObserver<Model.Person> resObs) {
//        System.out.println(req);
        final Model.Person savedPerson = repo.save(req.getPerson());
        resObs.onNext(Model.Person.newBuilder(savedPerson).build());
        resObs.onCompleted();
    }

    @Override
    public void get(MuniService.ById req, StreamObserver<Model.Person> resObs) {
        System.out.println("Search.personById " + req);
        String id = req.getId();
        Model.Person res = repo.get(id); //TODO handle not found
        resObs.onNext(res);
        resObs.onCompleted();
    }

    @Operation(
            summary = "All Persons",
            description = "Get all persons - do not put in production!"
    )
    @APIResponse(
            responseCode = "200",
            name = "Post list",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(
                            type = SchemaType.ARRAY,
                            implementation = MuniService.PersonList.class
                    )
            )
    )
    @Override
    public void getAll(Empty req, StreamObserver<MuniService.PersonList> resObs) {
        System.out.println(req);
        resObs.onNext(MuniService.PersonList.newBuilder().addAllPersons(repo.all()).build());
        resObs.onCompleted();
    }

    @Override
    public void update(Model.Person req, StreamObserver<Model.Person> resObs) {
        System.out.println(req);
        Model.Person res = repo.save(req);
        resObs.onNext(res);//TODO handle not found
        resObs.onCompleted();
    }
}
