package com.example.mycontact.repository;

import com.example.mycontact.domain.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void crud() {
        Person person = Person.builder()
                .name("노충내")
                .age(38)
                .bloodType("B형")
                .hobby("코인")
                .address("부장책상밑")
                .job("후론트라라후론트라라후론트라라라라라")
                .build();
        personRepository.save(person);
        System.out.println(personRepository.findAll());

        List<Person> people = personRepository.findAll();

        Assertions.assertEquals(people.size(), 1);
        Assertions.assertEquals(people.get(0).getName(), "노충내");
        Assertions.assertEquals(people.get(0).getAge(), 38);

    }

    @Test
    void 생성자_테스트(){
        //Person person = new Person("충내", 39);
    }

    @Test
    void 해시코드_이퀄스(){
        Person person = Person.builder()
                .name("짐승균")
                .age(48)
                .build();
        Person person1 = Person.builder()
                .name("짐승균")
                .age(48)
                .build();

        System.out.println(person.equals(person1));
        System.out.println(person.hashCode());
        System.out.println(person1.hashCode());

        Map<Person, Integer> map = new HashMap<>();
        map.put(person, person.getAge());

        System.out.println(map);
        // 가져올 수 없다. null임
        System.out.println(map.get(person1));

    }


}