package app.api;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.ConstrainedTo;
import javax.ws.rs.core.Application;
@OpenAPIDefinition(
        tags ={
                @Tag(name="mkm-api", description = "This API provides access for Person(customer), Organization, Case information")
        },
        info = @Info(
                title = "Markham API",
                version = "0.0.1",
                contact = @Contact(
                        name ="mkmapi",
                        url= "http://markham.ca/",
                        email = "pnataraj@markham.ca"
                )

        )
)
public class App extends Application {


}