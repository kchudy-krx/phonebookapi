package com.isa.contacts.config;

import com.isa.contacts.model.Person;
import com.isa.contacts.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class OnStart {

    @Autowired
    private Environment environment;

    @Autowired
    private PersonService personService;

    @PostConstruct
    public void init() {
        Person person1 = new Person();
        person1.setPhoneNumber("+48669887300");
        person1.setName("Anna");
        person1.setLastName("Kowalska");
        personService.save(person1);

        Person person2 = new Person();
        person2.setPhoneNumber("+48669887301");
        person2.setName("Piotr");
        person2.setLastName("Kowalski");
        personService.save(person2);

        Person person3 = new Person();
        person3.setPhoneNumber("+48669887302");
        person3.setName("Andrzej");
        person3.setLastName("Kowlaski");
        personService.save(person3);

    }
}
