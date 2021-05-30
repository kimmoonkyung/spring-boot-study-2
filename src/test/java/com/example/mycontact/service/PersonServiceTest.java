package com.example.mycontact.service;

import com.example.mycontact.domain.Block;
import com.example.mycontact.domain.Person;
import com.example.mycontact.repository.BlockRepository;
import com.example.mycontact.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        givenBlocks();

        List<Person> result = personService.getPeopleExcludeBlock();
        result.forEach(System.out::println);
    }

    private void givenBlocks() {
        givenBlock("짐승균");
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
                .block(givenBlock(name))
                .build();

        personRepository.save(blockPerson);
    }

    private Block givenBlock(String name) {
        Block blockPerson = Block.builder().name(name).build();
        System.out.println("### : " + blockPerson);
        return blockRepository.save(blockPerson);
    }
    private void givenPerson(String name, int age, String bloodType) {
        Person person = Person.builder().name(name).age(age).bloodType(bloodType).build();
        personRepository.save(person);
    }

}