package com.bilel.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;


public class PersonDto {
    private  String id;
    @NonNull
    private  String name;

    public PersonDto(@JsonProperty("id") String id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setId( String id) {
        this.id=id;
    }
    public void setName( String name) {
         this.name=name;
    }
}
