package com.tut.demo;

import com.tut.demo.entity.person;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface PersonRepository extends MongoRepository<person, String> {

}