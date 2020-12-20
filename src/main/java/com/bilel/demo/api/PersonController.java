package com.bilel.demo.api;

import com.bilel.demo.model.Person;
import com.bilel.demo.model.PersonDto;
import com.bilel.demo.service.PersonService;
import com.bilel.demo.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;
    @Autowired
    public PersonController(@Qualifier("PersonServiceMariaDb") PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@Validated @NonNull@RequestBody Person person){
        personService.addPerson(person);
    }

    @GetMapping
    public List<PersonDto> getPersons(){
        return personService.getPersons();
    }

    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") String id){
        return personService.findPersonById(id).orElse(null);
    }
    @DeleteMapping(path = "{id}")
    public void deletePerson(@PathVariable("id") String id){
        personService.deletePerson(id);
    }
    @PutMapping(path = "{id}")
    public int updatePerson(@PathVariable("id") String id, @Validated @NonNull @RequestBody Person newPerson){ ;
        return personService.updatePerson(id,newPerson);
    }
}
