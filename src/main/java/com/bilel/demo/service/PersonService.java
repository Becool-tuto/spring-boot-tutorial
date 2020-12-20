package com.bilel.demo.service;

import com.bilel.demo.model.Person;
import com.bilel.demo.model.PersonDto;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    public int addPerson(Person person);
    public List<PersonDto> getPersons();
    public Optional<Person> findPersonById(String id);
    public int deletePerson(String id);
    public int updatePerson(String id,Person newPerson);
}
