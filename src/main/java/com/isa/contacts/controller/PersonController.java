package com.isa.contacts.controller;

import com.isa.contacts.exception.ElementNotFoundException;
import com.isa.contacts.model.Person;
import com.isa.contacts.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    List<Person> findAll() {
        return personService.findAll();
    }

    @GetMapping("/{id}")
    Person findOne(@PathVariable("id") Integer id) {
        return personService.findById(id).orElseThrow(ElementNotFoundException::new);
    }

    @PostMapping
    Person add(@RequestBody Person person) {
        return personService.save(person);
    }

    @PutMapping("/{id}")
    Person edit(@PathVariable("id") Integer id, @RequestBody Person person) {
        return personService.update(id, person).orElseThrow(ElementNotFoundException::new);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    void delete(@PathVariable("id") Integer id) {
        personService.delete(id);
    }


}
