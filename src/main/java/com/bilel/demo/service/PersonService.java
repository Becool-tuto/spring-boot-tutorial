package com.bilel.demo.service;

import com.bilel.demo.dao.PersonDao;
import com.bilel.demo.model.Person;

public class PersonService {
    private final PersonDao personDao;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }
}
