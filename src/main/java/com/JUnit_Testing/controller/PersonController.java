package com.JUnit_Testing.controller;

import com.JUnit_Testing.Entity.Person;
import com.JUnit_Testing.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {



    @Autowired
    private PersonService personService;



    @GetMapping("/students")
    public ResponseEntity<?> getAllPersons() {
        try {
            return ResponseEntity.ok(this.personService.getAllPerson());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error fetching data from database");
        }
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<?> getPersonById(@PathVariable Integer id) {
        Person person = this.personService.getPersonById(id);
        if (person == null) {
            return ResponseEntity.status(404).body("Person not found with ID: " + id);
        }
        return ResponseEntity.ok(person);
    }

    @PostMapping("/person")
    public ResponseEntity<?> addPerson(@RequestBody Person person) {
        try {
            Person savedPerson = this.personService.addPerson(person);
            return ResponseEntity.status(201).body("Person added successfully: " + savedPerson);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error adding person");
        }
    }
}
