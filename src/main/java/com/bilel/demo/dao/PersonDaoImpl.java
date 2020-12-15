package com.bilel.demo.dao;

import com.bilel.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

//we use annotation to instantiate beans
//this class is served as repository
// we can use @Component also

@Repository("PersonDaoImpl")
public class PersonDaoImpl implements PersonDao{
    private static List<Person> DB = new ArrayList<>();
    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id,person.getName()));
        return 1;
    }

    @Override
    public List<Person> getPersons() {
        return DB;
    }

    @Override
    public Optional<Person> getPersonById(UUID id) {
        return DB.stream()
                .filter(person->id.equals(person.getId()))
                .findFirst();
    }

    @Override
    public int deletePerson(UUID id) {
       Optional<Person> person = getPersonById(id);
       if(person.isPresent()){
           DB.remove(person);
           return 1;
       }
       return 0;

    }

    @Override
    public int updatePerson(UUID id,Person update) {
        Optional<Person> personMayBe = getPersonById(id);
        personMayBe.map(person -> {
            int indexOfPersonToUpdate = DB.indexOf(person);
            if(indexOfPersonToUpdate >=0){
                DB.set(indexOfPersonToUpdate,new Person(id,update.getName()));
                return 1;
            }
           return 0;
        }).orElse(0);
        return 0;
    }
}
