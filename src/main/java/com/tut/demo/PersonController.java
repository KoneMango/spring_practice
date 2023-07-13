package com.tut.demo;

import com.tut.demo.entity.person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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

//    @GetMapping("/people/{id}")
//    public ResponseEntity<person> getPersonById(@PathVariable String id) {
//        Optional<person> personOptional = PersonRepository.findById(id);
//        if (personOptional.isPresent()) {
//            person person = personOptional.get();
//            return ResponseEntity.ok(person);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
}