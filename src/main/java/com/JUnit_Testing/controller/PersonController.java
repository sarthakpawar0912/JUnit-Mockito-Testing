package com.JUnit_Testing.controller;


import com.JUnit_Testing.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {


    @Autowired
    private PersonService personService;

    @GetMapping("/students")
    public ResponseEntity<?>getAllPersons(){
        return ResponseEntity.ok(this.personService.getAllPerson());
    }



}
