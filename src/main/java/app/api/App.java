package app.api;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

//import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
//import org.eclipse.microprofile.openapi.annotations.info.Contact;
//import org.eclipse.microprofile.openapi.annotations.info.Info;
//import org.eclipse.microprofile.openapi.annotations.tags.Tag;

//import javax.ws.rs.core.Application;
//@OpenAPIDefinition(
//        tags ={
//                @Tag(name="org-api", description = "This API provides access for Person(customer), Organization, Case information")
//        },
//        info = @Info(
//                title = "Org API",
//                version = "0.0.1",
//                contact = @Contact(
//                        name ="orgapi",
//                        url= "http://myorg/",
//                        email = "me.org"
//                )
//
//        )
//)
//@ApplicationPath("/mkapp/rest/v1") //TODO, make note this path here does not get appended to xxResource classes!
@QuarkusMain
public class App {
    public static void main(String ... args) {
        System.out.println("Running main method");
        Quarkus.run(args);
    }
}
