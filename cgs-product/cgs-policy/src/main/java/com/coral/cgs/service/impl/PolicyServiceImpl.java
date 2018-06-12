package com.coral.cgs.service.impl;

import com.coral.cgs.mapper.PersonMapper;
import com.coral.cgs.mapper.SequenceMapper;
import com.coral.cgs.mapper.VehicleInsuredMapper;
import com.coral.cgs.mapper.VehiclePolicyMapper;
import com.coral.cgs.model.vehicle.VehiclePolicyVO;
import com.coral.cgs.service.IPolicyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by ccc on 2018/5/22.
 */
@Service
public class PolicyServiceImpl implements IPolicyService {

    @Resource
    private SequenceMapper sequenceMapper;
    @Resource
    private VehiclePolicyMapper vehiclePolicyMapper;
    @Resource
    private VehicleInsuredMapper vehicleInsuredMapper;

    public void save(VehiclePolicyVO vehiclePolicyVO) {
        if(vehiclePolicyVO.getPolicyNo() == null) {
            vehiclePolicyVO.setPolicyNo(generatePolicyNo());
        }
        vehiclePolicyVO.setStatus("1");
        vehiclePolicyMapper.insertVehiclePolicy(vehiclePolicyVO);
    }

    @Override
    public VehiclePolicyVO load(String policyNo) {
        return vehiclePolicyMapper.load(policyNo);
    }

    public String generatePolicyNo() {
        return "NO" + String.format("%08d", sequenceMapper.getPolicyNoNextval());
    }

    public static void main(String[] args) {
        System.out.println(String.format("%08d", 1999));
    }
}
