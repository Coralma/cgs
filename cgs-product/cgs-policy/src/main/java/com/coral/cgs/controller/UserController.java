package com.coral.cgs.controller;

import com.coral.cgs.model.Person;
import com.coral.cgs.model.User;
import com.coral.cgs.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ccc on 2018/6/8.
 */
@Api(value = "UserController", description = "User Controller")
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    @ApiOperation("新建User")
    @ResponseBody
    @RequestMapping(value="/insert", method= RequestMethod.POST)
    public User insertUser(@RequestBody User user) {
        userService.insertUser(user);
        return user;
    }
}
