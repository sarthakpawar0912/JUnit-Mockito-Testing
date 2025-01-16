package com.JUnit_Testing.Service;

import com.JUnit_Testing.Entity.Person;
import com.JUnit_Testing.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPerson() {
        return this.personRepository.findAll();
    }

    public Person getPersonById(Integer personId) {
        Optional<Person> person = personRepository.findById(personId);
        return person.orElse(null);
    }

    public Person addPerson(Person person) {
        return personRepository.save(person);
    }
}
