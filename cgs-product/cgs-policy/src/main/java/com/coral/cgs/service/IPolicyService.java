package com.coral.cgs.service;

import com.coral.cgs.model.vehicle.VehiclePolicyVO;

/**
 * Created by ccc on 2018/5/22.
 */
public interface IPolicyService {

    void save(VehiclePolicyVO vehiclePolicyVO);
    VehiclePolicyVO load(String policyNo);
}
