package com.coral.cgs.mapper;

import com.coral.cgs.model.vehicle.VehicleInsuredVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by ccc on 2018/6/7.
 */
public interface VehicleInsuredMapper {

    @Insert("insert into t_vehicle_insured(insuredId,policyId,newCar,vehicleNo,vehicleBand,vehicleModel" +
            "engineNo,carFrameNo,usageType,belongType,registerDate,bodyType,premium,price,si) " +
            "value (#{vi.insuredId}, #{vi.policyId}, #{vi.newCar}, #{vi.vehicleNo}, #{vi.vehicleBand}, #{vi.vehicleModel}, " +
            "#{vi.engineNo}, #{vi.carFrameNo}, #{vi.usageType},#{vi.belongType},#{vi.registerDate}, #{vi.bodyType}, #{vi.premium}, #{vi.price}, #{vi.si})")
    @Options(useGeneratedKeys=true,keyProperty="vi.insuredId")
    int insertVehicleInsured(@Param("vi") VehicleInsuredVO vehicleInsuredVO);

    @Select("select * from t_vehicle_insured where policyId=#{policyId}")
    @ResultMap("vehicleInsuredMap")
    List<VehicleInsuredVO> load(String policyId);
}
