package com.example.Springboot.dao;

import com.example.Springboot.model.Person;

import java.util.UUID;

import org.springframework.stereotype.Repository;

// import data structures
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// associates with "PersonDao" file
@Repository("fakeDao") // serves as 'repository'
public class FakePersonDataAccessService implements PersonDao {

  // initialize new DB that'll contain 'Person's
  private static List<Person> DB = new ArrayList<>();

  @Override
  public int insertPerson(UUID id, Person person) {
    DB.add(new Person(id, person.getName()));
    return 1;
  }

  @Override
  public List<Person> selectAllPeople() {
    return DB;
  }

  // BUISNESS LOGIC BEHIND findOne, deleteOne, updateOne
  @Override
  public Optional<Person> selectPersonById(UUID id) {
    // find by ID
    return DB.stream()
            .filter(person -> person.getId().equals(id))
            .findFirst();
  }

  @Override
  public int deletePersonById(UUID id) {
    Optional<Person> personMaybe = selectPersonById(id);
    if (personMaybe.isEmpty()) {
      return 0;
    }
    DB.remove(personMaybe.get());
    return 1;
  }

  @Override
  public int updatePersonById(UUID id, Person update) {
    return selectPersonById(id)
            .map(person -> {
              int indexOfPersonToUpdate = DB.indexOf(person);
              if (indexOfPersonToUpdate >= 0) {
                DB.set(indexOfPersonToUpdate, new Person(id, update.getName()));
                return 1;
              } 
              return 0;
            })
            .orElse(0);
  }
}
