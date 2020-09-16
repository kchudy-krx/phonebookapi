package com.isa.contacts.service;

import com.isa.contacts.exception.ElementNotFoundException;
import com.isa.contacts.model.Person;
import com.isa.contacts.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;


    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Optional<Person> findById(Integer id) {
        return personRepository.findById(id);
    }

    @Transactional
    public Person save(Person person) {

        return personRepository.save(person);

    }

    @Transactional
    public Optional<Person> update(Integer personId, Person person) {
        return personRepository.findById(personId).map(p -> {
            p.setLastName(person.getLastName());
            p.setName(person.getName());
            p.setPhoneNumber(person.getPhoneNumber());
            return personRepository.save(p);
        });
    }


    @Transactional
    public void delete(Integer personId) {
        Optional<Person> personOptional = personRepository.findById(personId);
        personOptional.ifPresent(person -> personRepository.delete(person));
        personOptional.orElseThrow(ElementNotFoundException::new);
    }
}
