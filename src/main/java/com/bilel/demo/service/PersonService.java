package com.bilel.demo.service;

import com.bilel.demo.dao.PersonDao;
import com.bilel.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("PersonDaoImpl") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }

    public List<Person> getPersons(){
        return personDao.getPersons();
    }

    public Optional<Person> findPersonById(UUID id){
        return  personDao.getPersonById(id);
    }

    public int deletePerson(UUID id){
        return personDao.deletePerson(id);
    }
    public int updatePerson(UUID id,Person newPerson){
        return personDao.updatePerson(id,newPerson);
    }
}
