package com.bilel.demo.dao;

import com.bilel.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {
    int insertPerson(UUID id, Person person);

    default int insertPerson(Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id,person);
    }

    List<Person> getPersons();

    Optional<Person> getPersonById(UUID id);

    public int deletePerson(UUID id);

    public int updatePerson(UUID id,Person person);

}
