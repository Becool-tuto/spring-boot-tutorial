package com.bilel.demo.service;

import com.bilel.demo.PersonDtoMapper;
import com.bilel.demo.dao.PersonRepository;
import com.bilel.demo.model.Person;
import com.bilel.demo.model.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("PersonServiceMariaDb")
public class PersonServiceMariaDb implements PersonService{

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceMariaDb(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public int addPerson(Person person) {
        return 0;
    }

    @Override
    public List<PersonDto> getPersons() {
        List<PersonDto> result= new ArrayList<PersonDto>();
        List<Person> people = this.personRepository.findAll();
        if(people!=null){
            result = people.stream()
                         .map(PersonDtoMapper::fromPersonToPersonDto)
                         .collect(Collectors.toList());
        }

        return result;

    }

    @Override
    public Optional<Person> findPersonById(String id) {
        return Optional.empty();
    }

    @Override
    public int deletePerson(String id) {
        return 0;
    }

    @Override
    public int updatePerson(String id, Person newPerson) {
        return 0;
    }


}
