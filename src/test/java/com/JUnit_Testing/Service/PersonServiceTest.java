package com.JUnit_Testing.Service;

import com.JUnit_Testing.Repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;


    private PersonService personService;

    @BeforeEach
    void setUp() {
        this.personService = new PersonService(personRepository);
    }

    @Test
    void getAllPerson() {
        personService.getAllPerson();
        verify(personRepository).findAll();
    }
}