package com.example.Springboot.dao;

// import 'Person' model
import com.example.Springboot.model.Person;

import java.util.List;
import java.util.Optional;
// import UUID package
import java.util.UUID;

// must be interface
public interface PersonDao {
  // insert a new person
  int insertPerson(UUID id, Person person);

  // method to create new person
  default int insertPerson(Person person) {
    // create new UUID & create new person
    UUID id = UUID.randomUUID();
    return insertPerson(id, person);
  }

  List<Person> selectAllPeople();

  Optional<Person> selectPersonById(UUID id);

  // delete a person
  int deletePersonById(UUID id);
  
  // update a person
  int updatePersonById(UUID id, Person person);
}
