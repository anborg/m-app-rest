package app.repo;

import muni.model.Model;

import java.util.Collection;

public interface CustomerRepo {
    Model.Person personById(String id);

    Collection<Model.Person> personAll();

    Model.Person save(Model.Person person);
}
