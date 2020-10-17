package app.api;

import access.hansen.HansenUtil;
import access.integ.IntegUtil;
import io.quarkus.arc.DefaultBean;
import mkm.amanda.AmandaServiceImpl;
import muni.service.SubsystemService;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.ws.rs.Produces;

@Dependent
public class Config {

    @Produces
    @DefaultBean
    @Named("integ-service")
    public SubsystemService integService() {
        return IntegUtil.inMem();
    }

    @Produces
    @DefaultBean
    @Named("amanda")
    public SubsystemService amandaService() {
        return new AmandaServiceImpl();
    }

    @Produces
    @DefaultBean
    @Named("hansen")
    public SubsystemService hansenService() {
        return HansenUtil.dev();
    }

}
