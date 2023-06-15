package com.example.Springboot.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.Springboot.dao.PersonDao;
import com.example.Springboot.model.Person;

@Service
public class PersonService {

  private final PersonDao personDao;

  // Autowired == inject/autowire/insert into the interface
  @Autowired
  // Qualifier == specifies which implementation to use from 'dao' directory
  public PersonService(@Qualifier("fakeDao") PersonDao personDao) { // you can replace 'fakeDao' with 'postgres' to use the postgres DAO
    this.personDao = personDao;
  }
  
  public int addPerson(Person person) {
    return personDao.insertPerson(person);
  }

  public List<Person> getAllPeople() {
    return personDao.selectAllPeople();
  }

  public Optional<Person> getPersonById(UUID id) {
    return personDao.selectPersonById(id);
  }

  public int deletePerson(UUID id) {
    return personDao.deletePersonById(id);
  }

  public int updatePerson(UUID id, Person newPerson) {
    return personDao.updatePersonById(id, newPerson);
  }
}
