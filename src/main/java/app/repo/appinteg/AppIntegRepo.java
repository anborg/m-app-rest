package app.repo.appinteg;

import app.repo.PersonRepo;
import muni.model.Model;

import java.util.Collection;
import java.util.Optional;

@Deprecated
//@ApplicationScoped
public class AppIntegRepo implements PersonRepo {
//    @Inject
//    @Named("appinteg")
//    AgroalDataSource dataSource;

    @Override
    public Optional<Model.Person> get(Long id) {
        return null;
    }

    @Override
    public Collection<Model.Person> all() {
        return null;
    }

    @Override
    public Collection<Model.Person> byAddress(Model.PostalAddress address) {
        return null;
    }

    @Override
    public Model.Person save(Model.Person person) {
        return null;
    }
}
