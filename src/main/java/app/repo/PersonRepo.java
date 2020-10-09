package app.repo;

import muni.model.Model;

import java.util.Collection;
import java.util.List;

public interface PersonRepo {
    Model.Person get(String id);
    Collection<Model.Person> all();
    Collection<Model.Person> byAddress(Model.PostalAddress address);
    Model.Person save(Model.Person person);
}
