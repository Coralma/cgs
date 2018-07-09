package com.coral.cgs.service.impl;

import com.coral.cgs.mapper.AddressMapper;
import com.coral.cgs.mapper.PersonMapper;
import com.coral.cgs.mapper.UserMapper;
import com.coral.cgs.model.Address;
import com.coral.cgs.model.Person;
import com.coral.cgs.model.User;
import com.coral.cgs.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by ccc on 2018/6/8.
 */
@Service
public class UserServiceImpl implements IUserService {


    @Resource
    private UserMapper userMapper;

    @Resource
    private AddressMapper addressMapper;

    public Long insertUser(User user) {
        Long u = userMapper.insertUser(user);
        if(user.getAddressList() != null) {
            for (Address address : user.getAddressList()) {
                addressMapper.insertAddress(address, user.getUserId());
            }
        }
        return u;
    }

}
