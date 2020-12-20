package com.bilel.demo.service;

import com.bilel.demo.PersonDtoMapper;
import com.bilel.demo.dao.PersonDao;
import com.bilel.demo.model.Person;
import com.bilel.demo.model.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service("PersonServiceImpl")
public class PersonServiceImpl implements PersonService{
    private final PersonDao personDao;

    @Autowired
    public PersonServiceImpl(@Qualifier("PersonDaoImpl") PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }
    @Override
    public List<PersonDto> getPersons(){
        List<PersonDto> result= new ArrayList<PersonDto>();
        List<Person> people = this.personDao.getPersons();
        if(people!=null){
            result = people.stream()
                    .map(PersonDtoMapper::fromPersonToPersonDto)
                    .collect(Collectors.toList());
        }

        return result;
    }
    @Override
    public Optional<Person> findPersonById(String id){
        return  personDao.getPersonById(id);
    }
    @Override
    public int deletePerson(String id){
        return personDao.deletePerson(id);
    }
    @Override
    public int updatePerson(String id,Person newPerson){
        return personDao.updatePerson(id,newPerson);
    }
}
