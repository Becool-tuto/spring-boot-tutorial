package com.bilel.demo;


import com.bilel.demo.model.Person;
import com.bilel.demo.model.PersonDto;

public class PersonDtoMapper {

    public static final PersonDto fromPersonToPersonDto(Person person){

        return new PersonDto(person.getId(),person.getName());
    }

}
