package com.coral.cgs.mapper;

import com.coral.cgs.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

/**
 * Created by ccc on 2018/6/8.
 */
public interface UserMapper {

    @Insert("insert into t_user(username) value (#{u.username})")
    @Options(useGeneratedKeys=true,keyProperty="u.userId")
    Long insertUser(@Param("u") User user);
}
