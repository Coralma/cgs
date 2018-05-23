package com.coral.cgs.model.vehicle;

import com.coral.cgs.model.vehicle.VehiclePolicyVO;

/**
 * Created by ccc on 2018/5/21.
 */
public class VehiclePolicyResponse {

    boolean isSuccess = true;
    Long errorType;
    String errorMsg;
    VehiclePolicyVO vehiclePolicyVO;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public Long getErrorType() {
        return errorType;
    }

    public void setErrorType(Long errorType) {
        this.errorType = errorType;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public VehiclePolicyVO getVehiclePolicyVO() {
        return vehiclePolicyVO;
    }

    public void setVehiclePolicyVO(VehiclePolicyVO vehiclePolicyVO) {
        this.vehiclePolicyVO = vehiclePolicyVO;
    }
}
