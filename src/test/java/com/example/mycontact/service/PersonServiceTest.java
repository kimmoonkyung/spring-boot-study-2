package com.example.mycontact.service;

import com.example.mycontact.domain.Block;
import com.example.mycontact.domain.Person;
import com.example.mycontact.repository.BlockRepository;
import com.example.mycontact.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class PersonServiceTest {

    @Autowired
    private PersonService personService;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private BlockRepository blockRepository;

    @Test
    void getPeopleExcludeBlocks() {
        givenPeople();
        List<Person> result = personService.getPeopleExcludeBlock();
        result.forEach(System.out::println);
    }

    @Test
    void getPeopleByName(){
        givenPeople();
        List<Person> result = personService.getPeopleByName("짐승균");

        result.forEach(System.out::println);
    }

    @Test
    void cascadeTest() {
        givenPeople();
        List<Person> result = personRepository.findAll();
        result.forEach(System.out::println);

        Person person = result.get(3);
        person.getBlock().setStartDate(LocalDate.now());
        person.getBlock().setEndDate(LocalDate.now());

        personRepository.save(person);
        personRepository.findAll().forEach(System.out::println);

//        personRepository.delete(person);
//        personRepository.findAll().forEach(System.out::println);
//        blockRepository.findAll().forEach(System.out::println);

        person.setBlock(null);
        personRepository.save(person);
        personRepository.findAll().forEach(System.out::println);
        blockRepository.findAll().forEach(System.out::println);
    }

    @Test
    void getPerson() {
        givenPeople();

        Person person = personService.getPerson(3L);
        System.out.println(person);
    }

    private void givenPeople() {
        givenPerson("노충내", 38, "B");
        givenPerson("짐승균", 44, "AB");
        givenBlockPerson("짐승균", 66, "B");
        givenBlockPerson("짐승내", 28, "O");
        givenPerson("김부엉", 29, "A");
    }

    private void givenBlockPerson(String name, int age, String bloodType){
        Person blockPerson = Person.builder()
                .name(name)
                .age(age)
                .bloodType(bloodType)
//                .block(givenBlock(name))
                .block(Block.builder().name(name).build())
                .build();

        personRepository.save(blockPerson);
    }
    private void givenPerson(String name, int age, String bloodType) {
        Person person = Person.builder().name(name).age(age).bloodType(bloodType).build();
        personRepository.save(person);
    }

}