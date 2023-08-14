package com.example.WorkSchedule.services;

import com.example.WorkSchedule.models.Person;
import com.example.WorkSchedule.repositoryes.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    public Iterable<Person> getAllPersons(){
        return personRepository.findPersons();
    }
    public List<Person> findPersonByFio(String fio){
        return personRepository.findPersonByFio(fio);
    }
    public List<Person> findPersonByLastname(String lastname){
        return personRepository.findPersonByLastname(lastname);
    }
    public List<Person> findPersonByFullname(String fullname){
        return personRepository.findPersonByFullname(fullname);
    }
    public void addPerson(Person person){
        personRepository.addPerson(person.getLastname(),
                person.getFirstname(),
                person.getSecondname(),
                person.getFio(),
                person.getFullname(),
                person.getTabnum());
    }
    public void deletePerson(long id){
        personRepository.deletePerson(id);
    }
    public void changePerson(Person person){
        personRepository.changePerson(person.getId(),
                person.getLastname(),
                person.getFirstname(),
                person.getSecondname(),
                person.getFio(),
                person.getFullname());
    }
    public void changePersonFio(Person person){
        personRepository.changePersonFio(person.getId(), person.getFio());
    }
    public void changePersonTabnum(Person person){
        personRepository.changePersonTabnum(person.getId(), person.getTabnum());
    }
    public void changePersonLastname(Person person){
        personRepository.changePersonLastname(person.getId(), person.getLastname());
    }
    public void changePersonFullname(Person person){
        personRepository.changePersonFullname(person.getId(), person.getFullname());
    }
}
