package com.example.mycontact.domain;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

    private String hobby;

    private String bloodType;

    private String address;

    private LocalDate birthday;

    private String job;

    private String phoneNumber;

//    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
//    @OneToOne(cascade = {CascadeType.ALL})
    @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true)
    private Block block;

//    private boolean block;
//
//    private String blockReason;
//
//    private LocalDate blockStartDate;
//
//    private LocalDate blockEndDate;

//    public boolean equals(Object object) {
//        if(object == null){
//            return false;
//        }
//        Person person = (Person) object;
//        if(!person.getName().equals(this.getName())){
//            return false;
//        }
//        if(person.getAge() != this.getAge()){
//            return false;
//        }
//        return true;
//    }
//
//    public int hashCode(){
//        return (name + age).hashCode();
//    }

}
