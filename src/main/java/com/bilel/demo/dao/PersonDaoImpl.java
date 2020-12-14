package com.bilel.demo.dao;

import com.bilel.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
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
}
