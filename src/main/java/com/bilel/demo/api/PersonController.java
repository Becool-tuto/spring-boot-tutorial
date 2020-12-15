package com.bilel.demo.api;

import com.bilel.demo.model.Person;
import com.bilel.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getPersons(){
        return personService.getPersons();
    }

    public Person getPersonById(UUID id){
        return personService.findPersonById(id).orElse(null);
    }
}
