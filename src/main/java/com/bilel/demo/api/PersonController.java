package com.bilel.demo.api;

import com.bilel.demo.model.Person;
import com.bilel.demo.service.PersonService;

public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    public void addPerson(Person person){
        personService.addPerson(person);
    }
}
