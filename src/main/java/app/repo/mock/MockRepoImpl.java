package app.repo.mock;
import app.repo.CustomerRepo;
import muni.model.Model;
import muni.util.MockUtil;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class MockRepoImpl implements CustomerRepo {
    static List<Model.Person> list = Arrays.asList(
            MockUtil.buildPerson("1","Jane", "Doe"),
            MockUtil.buildPerson("2","Peter", "Stock")
    );

    static Map<String, Model.Person> map = null;

    static{
        map = list.stream().collect(Collectors.toMap(Model.Person::getId, Function.identity()));
    }


    @Override
    public Model.Person personById(String id){
        final Model.Person out = map.get(id);
        System.out.println( "Mock: person=" +id +" , obj= "+ out);
        return out;
    }
    @Override
    public Collection<Model.Person> personAll(){
        return map.values();
    }

    @Override
    public Model.Person save(Model.Person person) {
        String newId = ""+ (map.size()+1);
        System.out.println("newId = " + newId);
        final Model.Person savePerson = Model.Person.newBuilder(person).setId(newId).build();
        map.put(newId,savePerson);
        return savePerson;
    }
}
