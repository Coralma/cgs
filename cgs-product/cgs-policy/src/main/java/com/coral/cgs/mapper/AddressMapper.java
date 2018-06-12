package com.coral.cgs.mapper;

import com.coral.cgs.model.Address;
import com.coral.cgs.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

/**
 * Created by ccc on 2018/6/11.
 */
public interface AddressMapper {

    @Insert("insert into t_user_address(userId, address, postNo) value (#{userId}, #{address.address},#{address.postNo})")
    @Options(useGeneratedKeys=true,keyProperty="address.addressId")
    Long insertAddress(@Param("address")Address address, @Param("userId") Long userId);
}
