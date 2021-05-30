package com.example.mycontact.repository;

import com.example.mycontact.domain.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void crud() {
        Person person = Person.builder()
                .name("노충내")
                .age(38)
                .build();
        personRepository.save(person);
//        System.out.println(personRepository.findAll());

        List<Person> people = personRepository.findAll();

        Assertions.assertEquals(people.size(), 1);
        Assertions.assertEquals(people.get(0).getName(), "노충내");
        Assertions.assertEquals(people.get(0).getAge(), 38);

    }

}