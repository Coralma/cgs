package com.coral.cgs.mapper;

import com.coral.cgs.model.Person;
import com.coral.cgs.model.vehicle.VehiclePolicyVO;
import org.apache.ibatis.annotations.*;

/**
 * Created by ccc on 2018/5/22.
 */
public interface VehiclePolicyMapper {

    @Insert("insert into t_vehicle_policy(policyNo,effectiveDate,expiryDate,status,policyHolderName,gender," +
            "birthday,idType,idNo,address,postNo,mobilePhone,companyPhone,homePhone,si,premium) " +
            "value (#{vp.policyNo}, #{vp.effectiveDate}, #{vp.expiryDate}, #{vp.status}, #{vp.policyHolderName}, #{vp.gender}, " +
            "#{vp.birthday}, #{vp.idType}, #{vp.idNo},#{vp.address},#{vp.postNo}, #{vp.mobilePhone}, #{vp.companyPhone}, #{vp.homePhone}, #{vp.si}, #{vp.premium})")
    @Options(useGeneratedKeys=true,keyProperty="vp.policyId")
    int insertVehiclePolicy(@Param("vp") VehiclePolicyVO vehiclePolicyVO);

    @Select("select * from t_vehicle_policy where policyNo=#{policyNo}")
    @ResultMap("vehiclePolicyMap")
    VehiclePolicyVO load(String policyNo);
}
