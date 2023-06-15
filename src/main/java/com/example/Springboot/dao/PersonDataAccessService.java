package com.example.Springboot.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.Springboot.model.Person;

// different 'data access service' with a specified name
@Repository("postgres")
public class PersonDataAccessService implements PersonDao {

  @Override
  public int insertPerson(UUID id, Person person) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'insertPerson'");
  }

  @Override
  public List<Person> selectAllPeople() {
    return List.of(new Person(UUID.randomUUID(), "FROM POSTGRES DB"));
  }

  @Override
  public Optional<Person> selectPersonById(UUID id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'selectPersonById'");
  }

  @Override
  public int deletePersonById(UUID id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deletePersonById'");
  }

  @Override
  public int updatePersonById(UUID id, Person person) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'updatePersonById'");
  }
  
}
