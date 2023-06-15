package com.example.Springboot.api;

import com.example.Springboot.model.Person;
import com.example.Springboot.service.PersonService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

  private final PersonService personService;

  // constructor to define variables
  @Autowired
  public PersonController(PersonService personService) {
    this.personService = personService;
  }
  
  // makes this POST request
  @PostMapping
  public void addPerson(@Valid @NotNull @RequestBody Person person) {
    System.out.println("Request to create a new person");
    personService.addPerson(person);
  }

  // makes this a GET request
  @GetMapping
  public List<Person> getAllPeople() {
    System.out.println("Request to get all people");
    System.out.println(personService.getAllPeople());
    return personService.getAllPeople();
  }

  // FIND ONE person
  @GetMapping(path = "{id}") // extract variables from url parameter
  public Person getPersonById(@PathVariable("id") UUID id) { // Path variable == useParams()
    System.out.println("Request to get person by id");
    return personService.getPersonById(id)
            .orElse(null);
  }

  // DELETE a person
  @DeleteMapping(path = "{id}")
  public void deletePersonById(@PathVariable("id") UUID id) {
    System.out.println("Request to delete a person");
    personService.deletePerson(id);
  }

  // UPDATE a person
  @PutMapping(path = "{id}")
  // @Valid & @NotNull == can't have empty values
  public void updatePerson(@PathVariable("id") UUID id, @Valid @NotNull @RequestBody Person personToUpdate) {
    System.out.println("Request to update a person");
    personService.updatePerson(id, personToUpdate);
  }
}
