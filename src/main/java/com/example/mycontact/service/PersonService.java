package com.example.mycontact.service;

import com.example.mycontact.domain.Person;
import com.example.mycontact.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        return people.stream().filter(person -> person.getBlock() == null).collect(Collectors.toList());
    }

}
