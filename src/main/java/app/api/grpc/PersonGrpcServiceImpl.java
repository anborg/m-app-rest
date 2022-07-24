package app.api.grpc;

import access.integ.IntegService;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import muni.model.Model;
import muni.model.MuniService;
import muni.model.PersonServiceGrpc;
//import org.eclipse.microprofile.openapi.annotations.Operation;
//import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
//import org.eclipse.microprofile.openapi.annotations.media.Content;
//import org.eclipse.microprofile.openapi.annotations.media.Schema;
//import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import javax.inject.Named;
import javax.inject.Singleton;
import java.util.Optional;
import java.util.logging.Logger;

import io.quarkus.grpc.GrpcService;
@Singleton
@GrpcService
public class PersonGrpcServiceImpl extends PersonServiceGrpc.PersonServiceImplBase {
    private static Logger logger = Logger.getLogger(PersonGrpcServiceImpl.class.getName());
    //    PersonRepo repo = new MockRepoImpl();
    @Named("integ-service")
    IntegService integSvc;

    @Override
    public void create(Model.Person req, StreamObserver<Model.Person> responseObserver) {
        //logger.info(req);
        final Model.Person savedPerson = integSvc.create(req);
        responseObserver.onNext(Model.Person.newBuilder(savedPerson).build());
        responseObserver.onCompleted();
    }

    @Override
    public void update(Model.Person req, StreamObserver<Model.Person> responseObserver) {
        logger.info("At grpc update: pers= "+req.getId());
        Model.Person res = integSvc.update(req);
        responseObserver.onNext(res);//TODO handle not found
        responseObserver.onCompleted();
    }

    @Override
    public void get(MuniService.ById req, StreamObserver<Model.Person> responseObserver) {
        logger.info("PersonGrpc personById " + req);
        Long id = req.getId();
        Optional<Model.Person> res = integSvc.getPerson(id); //TODO handle not found
        if (res.isPresent()) {
            responseObserver.onNext(res.get());
        } else {
            responseObserver.onNext(null);
        }
        responseObserver.onCompleted();
    }

    @Override
    public void xrefAdd(Model.Xref request, StreamObserver<Model.Xref> responseObserver) {
        super.xrefAdd(request, responseObserver);
    }

    @Override
    public void xrefUpdate(Model.Xref request, StreamObserver<Model.Xref> responseObserver) {
        super.xrefUpdate(request, responseObserver);
    }

    @Override
    public void xrefSync(Model.Xref request, StreamObserver<Model.Xref> responseObserver) {
        super.xrefSync(request, responseObserver);
    }

//    @Operation(
//            summary = "All Persons",
//            description = "Get all persons - do not put in production!"
//    )
//    @APIResponse(
//            responseCode = "200",
//            name = "Post list",
//            content = @Content(
//                    mediaType = "application/json",
//                    schema = @Schema(
//                            type = SchemaType.ARRAY,
//                            implementation = MuniService.PersonList.class
//                    )
//            )
//    )
    @Override
    public void getAll(Empty req, StreamObserver<MuniService.PersonList> responseObserver) {
        logger.info(req.toString());
        responseObserver.onNext(MuniService.PersonList.newBuilder().addAllPersons(integSvc.personsRecent()).build());
        responseObserver.onCompleted();
    }


}
