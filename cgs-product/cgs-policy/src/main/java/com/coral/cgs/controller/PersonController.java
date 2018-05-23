package com.coral.cgs.controller;

import com.coral.cgs.model.Person;
import com.coral.cgs.service.IPersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Api(value = "PersonController", description = "Mybatis测试案例")
@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    IPersonService personService;

    @ApiOperation("新建Person信息")
    @ResponseBody
    @RequestMapping(value="/insert", method= RequestMethod.POST)
    public Person insertPerson(@RequestBody Person person) {
        personService.insertPerson(person);
        return person;
    }

    @ApiOperation("通过ID获取Person")
    @ResponseBody
    @RequestMapping(value="/getPersonById", method= RequestMethod.GET)
    public Person getPerson(Long id) {
        return personService.getPerson(id);
    }

    @ApiOperation("通过Name获取Person")
    @ResponseBody
    @RequestMapping(value="/getPersonByName", method= RequestMethod.GET)
    public Person getPersonByName(String username) {
        return personService.getPersonByName(username);
    }

    @ApiOperation("返回全部Person")
    @ResponseBody
    @RequestMapping(value="/getAll", method= RequestMethod.GET)
    public List<Person> getAllPerson() {
        return personService.getAllPerson();
    }

    @ApiOperation("统计Person数量")
    @ResponseBody
    @RequestMapping(value="/countPerson", method= RequestMethod.GET)
    public Long countPerson(){
        return personService.countPerson();
    }
}
