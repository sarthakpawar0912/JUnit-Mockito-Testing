package com.JUnit_Testing.Repository;

import com.JUnit_Testing.Entity.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class PersonRepositoryTest {


    @Autowired
    private PersonRepository personRepository;


    @Test
    void isPersonExistsById() {
        // Create a new Person entity
        Person person = new Person(111, "Sarthak", "PCMC");
        // Save the person in the repository
        personRepository.save(person);
        // Check if the person exists by ID
        Boolean actualResult = personRepository.isPersonExistsById(111);
        // Assert that the result is true
        assertThat(actualResult).isTrue();
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearing down");
        personRepository.deleteAll();

    }
    @BeforeEach
    void setUp(){
        System.out.println("setting up");

    }

}
