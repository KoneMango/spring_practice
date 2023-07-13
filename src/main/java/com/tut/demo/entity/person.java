package com.tut.demo.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="mydatabase")
public class person {

    @Id
    private ObjectId _id;

    private String name;

    private String id;

    private String age;


    // getters and setters
}
