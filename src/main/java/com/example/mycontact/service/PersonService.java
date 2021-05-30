package com.example.mycontact.service;

import com.example.mycontact.domain.Person;
import com.example.mycontact.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Slf4j
@Service
@AllArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    //private final BlockRepository blockRepository;

    public List<Person> getPeopleExcludeBlock(){
        List<Person> people = personRepository.findAll();
//        List<Block> blocks = blockRepository.findAll();
//        List<String> blockName = blocks.stream().map(Block::getName).collect(Collectors.toList());
//        return people.stream().filter(person -> !blockName.contains(person.getName())).collect(Collectors.toList());

//        return people.stream().filter(person -> person.getBlock() == null).collect(Collectors.toList());
        return personRepository.findByBlockIsNull();
    }

    public List<Person> getPeopleByName(String name) {
        List<Person> people = personRepository.findAll();

//        return people.stream().filter(person -> person.getName().equals(name)).collect(Collectors.toList());
        return personRepository.findByName(name);
    }

    @Transactional(readOnly = true)
    public Person getPerson(Long id) {
        Person person = personRepository.findById(id).get();
        log.info("person : {}", person);
        return person;
    }

}
