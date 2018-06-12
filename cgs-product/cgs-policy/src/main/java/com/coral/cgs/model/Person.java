package com.coral.cgs.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Gude.
 * @Date 2017/4/8.
 */
@ApiModel(description= "返回用户数据")
public class Person implements Serializable {

    @ApiModelProperty(value = "用户ID",required=false)
    private Long id;
    @ApiModelProperty(value = "用户名",required=true)
    private String username;
    @ApiModelProperty(value = "密码",required=true)
    private String password;
    @ApiModelProperty(value = "工作信息")
    private String job;

    public Person() {

    }

    public Person(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }


}
