package com.isa.contacts.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {

    @Id
    @GeneratedValue()
    private Integer id;

    private String name;

    private String lastName;

    private String phoneNumber;

}
