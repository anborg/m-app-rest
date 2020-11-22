package app.api;

import access.amanda.AmandaUtil;
import access.hansen.HansenUtil;
import access.integ.IntegService;
import access.integ.IntegUtil;
import io.quarkus.arc.DefaultBean;
import muni.service.SubsystemService;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.ws.rs.Produces;

@Dependent
public class Config {

    @Produces
    @DefaultBean
    @Named("integ-service")
    public IntegService integService() {
        return IntegUtil.mock();
    }

    @Produces
    @DefaultBean
    @Named("amanda")
    public SubsystemService amandaService() {
        return AmandaUtil.mock();
    }

    @Produces
    @DefaultBean
    @Named("hansen")
    public SubsystemService hansenService() {
        return HansenUtil.mock();
    }

}
