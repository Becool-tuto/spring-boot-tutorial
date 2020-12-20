package com.bilel.demo.dao;

import com.bilel.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {
    int insertPerson(String id, Person person);

    default int insertPerson(Person person){
        String id = UUID.randomUUID().toString();
        return insertPerson(id,person);
    }

    List<Person> getPersons();

    Optional<Person> getPersonById(String id);

    public int deletePerson(String id);

    public int updatePerson(String id,Person person);

}
