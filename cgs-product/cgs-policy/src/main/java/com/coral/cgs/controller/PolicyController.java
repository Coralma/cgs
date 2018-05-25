package com.coral.cgs.controller;

import com.coral.cgs.model.vehicle.VehiclePolicyResponse;
import com.coral.cgs.model.vehicle.VehiclePolicyVO;
import com.coral.cgs.service.IPolicyService;
import com.coral.cgs.service.impl.PolicyServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Api(value = "PolicyController", description = "保单管理")
@Controller
@RequestMapping("/policy")
public class PolicyController {

    @Autowired
    IPolicyService policyService;

    @ApiOperation("保单保存接口")
    @ResponseBody
    @RequestMapping(value="/load", method= RequestMethod.GET)
    public VehiclePolicyResponse loadPolicy(@ApiParam(name = "policyNo", value = "保单号", required = true) @RequestParam("policyNo") String policyNo) {
        VehiclePolicyVO vehiclePolicyVO = policyService.load(policyNo);
        return successResponse(vehiclePolicyVO);
    }

    @ApiOperation("保单保存接口")
    @ResponseBody
    @RequestMapping(value="/save", method= RequestMethod.POST)
    public VehiclePolicyResponse savePolicy(@RequestBody VehiclePolicyVO vehiclePolicyVO) {
        policyService.save(vehiclePolicyVO);
        return successResponse(vehiclePolicyVO);
    }

    @ApiOperation("保单出单接口")
    @ResponseBody
    @RequestMapping(value="/issue", method= RequestMethod.POST)
    public VehiclePolicyResponse issuePolicy(@RequestBody VehiclePolicyVO vehiclePolicyVO) {
        vehiclePolicyVO.setStatus("2");
        return successResponse(vehiclePolicyVO);
    }

    @ApiOperation("保费计算接口")
    @ResponseBody
    @RequestMapping(value="/premiumCalculation", method= RequestMethod.POST)
    public VehiclePolicyResponse premiumCalculation(@RequestBody VehiclePolicyVO vehiclePolicyVO) {
        vehiclePolicyVO.setStatus("2");
        vehiclePolicyVO.setPremium(new BigDecimal(999));
        return successResponse(vehiclePolicyVO);
    }

    public VehiclePolicyResponse successResponse(VehiclePolicyVO vehiclePolicyVO) {
        VehiclePolicyResponse vehiclePolicyResponse = new VehiclePolicyResponse();
        vehiclePolicyResponse.setIsSuccess(true);
        vehiclePolicyResponse.setVehiclePolicyVO(vehiclePolicyVO);
        return vehiclePolicyResponse;
    }
}
