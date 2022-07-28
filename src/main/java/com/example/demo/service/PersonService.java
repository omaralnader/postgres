package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

  private final PersonDao personDao;

  @Autowired
//  public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
  public PersonService(@Qualifier("postgres") PersonDao personDao) {
    this.personDao = personDao;
  }

  public int addPerson(Person person) {
	  return personDao.insertPerson(person);
  }
  
  public List<Person> getAllPeople() {
    return personDao.selectAllPeople();
  }

//  UUID insertNewPerson(Person person) {
//    return personDao.addPerson(person);
//  }

  public Optional<Person> getPersonById(UUID id) {
    return personDao.selectPersonById(id);
  }

  public void deletePerson(UUID id) {
    personDao.deletePersonById(id);
  }

  public void updatePerson(UUID id, Person newPerson) {
    personDao.updatePersonById(id, newPerson);
  }
}
