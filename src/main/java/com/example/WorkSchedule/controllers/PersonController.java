package com.example.WorkSchedule.controllers;

import com.example.WorkSchedule.models.Person;
import com.example.WorkSchedule.services.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @GetMapping("/persons")
    public String getAllPersons(@RequestParam(required = false) String type,
                                @RequestParam(required = false) String name,
                                Model model){
        Iterable<Person> persons = new ArrayList<>();
        if(type == null){
            persons = personService.getAllPersons();
        }else {
            if(type.equals("fio")){
                persons = personService.findPersonByFio(name);
            }
            if(type.equals("lastname")){
                persons = personService.findPersonByLastname(name);
            }
            if(type.equals("fullname")){
                persons = personService.findPersonByFullname(name);
            }
        }
        model.addAttribute("persons",persons);
        return "persons.html";
    }

    @PostMapping("/person")
    public String addPerson(@RequestParam String lastname,
                            @RequestParam String firstname,
                            @RequestParam String secondname,
                            @RequestParam String tabnum,
                            Model model){
        Person person = new Person();
        person.setLastname(lastname);
        person.setFirstname(firstname);
        person.setSecondname(secondname);
        person.setFio();
        person.setFullname();
        person.setTabnum(tabnum);
        personService.addPerson(person);
        Iterable<Person> persons = personService.getAllPersons();
        return "persons.html";
    }
}
