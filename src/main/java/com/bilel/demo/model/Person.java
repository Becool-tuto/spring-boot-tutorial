package com.bilel.demo.model;

import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class Person {

    @Id
    private  String id;
    @Column(name = "name")
    private  String name;

    public Person() {

    }

    public Person(String id, @NonNull String name) {
        this.id = id;
        this.name = name;
    }



    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
