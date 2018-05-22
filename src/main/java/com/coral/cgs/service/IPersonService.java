package com.coral.cgs.service;

import com.coral.cgs.model.Person;

import java.util.List;

/**
 * Created by ccc on 2018/5/22.
 */
public interface IPersonService {

    int insertPerson(Person person);
    Person getPerson(Long id);
    Person getPersonByName(String username);
    List<Person> getAllPerson();
    Long countPerson();
}
