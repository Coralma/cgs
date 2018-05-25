package com.coral.cgs.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * Created by ccc on 2018/5/25.
 */
public interface SequenceMapper {

    @Select("select nextval('policyNo')")
    Long getPolicyNoNextval();
}
