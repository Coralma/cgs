package com.coral.cgs.controller;

import com.coral.cgs.model.Person;
import io.swagger.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 */
@Api(value = "HelloController", description = "Hello World to Swagger")
@Controller
@RequestMapping("/base")
public class HelloController {

    @ApiOperation("hello")
    @ResponseBody
    @RequestMapping(value="/hello", method= RequestMethod.GET)
    public String helloWorld() {
        return "Hello World!";
    }

    @ApiOperation("json返回测试")
    @ResponseBody
    @RequestMapping(value="/json", method= RequestMethod.GET)
    public Person testJson() {
        Person person = new Person("gude", "111111");
        return person;
    }
}
