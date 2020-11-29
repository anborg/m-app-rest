package app.repo.mock;
import app.repo.PersonRepo;
import muni.model.Model;
import muni.util.MockUtil;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Deprecated
public class MockRepoImpl implements PersonRepo {
    static List<Model.Person> list = Arrays.asList(
            MockUtil.buildPerson("1","Jane", "Doe"),
            MockUtil.buildPerson("2","Peter", "Stock")
    );

    static Map<String, Model.Person> map = null;

    static{
        map = list.stream().collect(Collectors.toMap(Model.Person::getId, Function.identity()));
    }


    @Override
    public Optional<Model.Person> get(String id) {
        final Model.Person out = map.get(id);
        //System.out.println( "Mock: person=" +id +" , obj= "+ out);
        return Optional.of(out);
    }

    @Override
    public Collection<Model.Person> byAddress(Model.PostalAddress address) {
        //
        return map.values();
    }

    @Override
    public Collection<Model.Person> all() {
        return map.values();
    }

    @Override
    public Model.Person save(Model.Person in) {
        String updateId = in.getId();
        System.out.println("updateId = " + updateId);
        Optional<Model.Person> pExistingOpt = get(updateId);
        Model.Person pExisting = pExistingOpt.get();
        Model.Person.Builder outBuild = Model.Person.newBuilder(pExisting);
        boolean hasChange = false;
        //Change only fields that are provided in POST body.
        //TODO do not compare createTs, updateTs -- they are not provided in POST to update.
        if (!in.getFirstName().isEmpty()) { //TODO - How to use "merge" instead of manual compare. Is there a util?
            if (!Objects.equals(in.getFirstName(), pExisting.getFirstName())) {
                outBuild.setFirstName(in.getFirstName());
                hasChange = true;
            }
        }
        if (!in.getLastName().isEmpty()) {
            if (!Objects.equals(in.getLastName(), pExisting.getLastName())) {
                outBuild.setLastName(in.getLastName());
                hasChange = true;
            }
        }

        if (!hasChange) {
            System.out.println("Nothing to update ... " + System.currentTimeMillis());
            return pExisting;
        }
        final Model.Person updatePerson = outBuild.build();
        map.put(updateId, updatePerson); //TODO move to H2 or postgres later
        return updatePerson;
    }
}
