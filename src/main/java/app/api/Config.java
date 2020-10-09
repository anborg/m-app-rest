package app.api;

import io.quarkus.arc.DefaultBean;
import mkm.service.SubsystemService;
import mkm.amanda.AmandaServiceImpl;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.ws.rs.Produces;

@Dependent
public class Config {

    @Produces
    @DefaultBean
    @Named("amanda")
    public SubsystemService amandaService(){
        return new AmandaServiceImpl();
    }
}
