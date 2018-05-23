package com.coral.cgs.mapper;

import com.coral.cgs.model.Person;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * Created by ccc on 2018/5/22.
 */
public interface PersonMapper {

    @Insert("insert into t_person(username, password, job) value (#{person.username}, #{person.password}, #{person.job})")
    @Options(useGeneratedKeys=true,keyProperty="person.id")
    int insertPerson(@Param("person") Person person);

    @Select("select * from t_person where id=#{id}")
    @Results({
        @Result(id=true,property="id",column="id",javaType=Long.class),
        @Result(property="username",column="username",javaType=String.class),
        @Result(property="password",column="password",javaType=String.class),
        @Result(property="job",column="job",javaType=String.class)
    })
    Person getPerson(Long id);

    @Select("select * from t_person where username=#{username}")
    @ResultMap("personMap")
    Person getPersonByName(String username);

    @Select("select * from t_person")
    @Results({
            @Result(id=true,property="id",column="id",javaType=Long.class),
            @Result(property="username",column="username",javaType=String.class),
            @Result(property="password",column="password",javaType=String.class),
            @Result(property="job",column="job",javaType=String.class)
    })
    List<Person> getAllPerson();

    Long countPerson(Map<String, Object> params);
}
