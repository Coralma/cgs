package com.coral.cgs.service.impl;

import com.coral.cgs.mapper.PersonMapper;
import com.coral.cgs.model.Person;
import com.coral.cgs.service.IPersonService;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by ccc on 2018/5/22.
 */
@Service
public class PersonServiceImpl implements IPersonService {

    @Resource
    private PersonMapper personMapper;

    public int insertPerson(Person person) {
        return personMapper.insertPerson(person);
    }

    public Person getPerson(Long id) {
        return personMapper.getPerson(id);
    }

    public Person getPersonByName(String username) {
        return personMapper.getPersonByName(username);
    }

    public List<Person> getAllPerson() {
        return personMapper.getAllPerson();
    }

    public Long countPerson() {
        Map<String, Object> params = Maps.newHashMap();
        return personMapper.countPerson(params);
    }

}
