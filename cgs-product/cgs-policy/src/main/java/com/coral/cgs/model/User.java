package com.coral.cgs.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by ccc on 2018/6/8.
 */
public class User {

    private Long userId;

    @ApiModelProperty(value = "用户名",required=true)
    private String username;

    @ApiModelProperty(value = "地址信息")
    private List<Address> addressList;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }
}
