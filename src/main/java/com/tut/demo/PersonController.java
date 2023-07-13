package com.tut.demo;

import com.tut.demo.entity.person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
//public class HelloWorldController {
//
//    @GetMapping("/hello")
//    public String helloWorld() {
//        return "Hello World";
//    }
//
//    @GetMapping("/bye")
//    public String bye(){
//        return "bye";
//    }
//    @GetMapping("/error")
//    public String error(){
//        return "error";
//    }
//
//}

@RestController
public class PersonController {

    @Autowired
    private PersonRepository PersonRepository;

    @GetMapping("/people")
    public List<person> getPeople() {
        return PersonRepository.findAll();
    }
}