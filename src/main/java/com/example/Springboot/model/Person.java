package com.example.Springboot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

// import UUID package
import java.util.UUID;

// initialize a CLASS
// just like a model in JS (i.e. "User" model)
public class Person {

  // define model properties
  private final UUID id;
  @NotBlank
  private final String name;
  private final int age;

  // initialize constructor
  public Person(@JsonProperty("id") UUID id, @JsonProperty("name") String name, @JsonProperty("age") int age) {
    this.id = id;
    this.name = name;
    this.age = age;
  }

  // initialize getters
  public UUID getId() {
    return id;
  }
  public String getName() {
    return name;
  }
  public int getAge() {
    return age;
  }
  
}
