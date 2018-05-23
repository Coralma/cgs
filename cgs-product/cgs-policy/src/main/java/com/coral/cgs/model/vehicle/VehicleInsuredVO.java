package com.coral.cgs.model.vehicle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ApiModel(description= "车险标的模型")
public class VehicleInsuredVO implements Serializable {

    @ApiModelProperty(value = "车险标的ID", required=true)
    Long insuredId;
    @ApiModelProperty(value = "是否新车", required=true)
    Boolean isNew = false;
    @ApiModelProperty(value = "车牌", required=true)
    String vehicleNo;
    @ApiModelProperty(value = "车辆厂牌", required=true)
    String vehicleBand;
    @ApiModelProperty(value = "车辆款型", required=true)
    String vehicleModel;
    @ApiModelProperty(value = "引擎号", required=true)
    String engineNo;
    @ApiModelProperty(value = "车架号", required=true)
    String carFrameNo;
    @ApiModelProperty(value = "使用性质", required=true)
    String usageType;
    @ApiModelProperty(value = "所属性质", required=true)
    String belongType;
    @ApiModelProperty(value = "初次登记年月", required=true)
    Date registerDate;
    @ApiModelProperty(value = "车辆种类", required=true)
    String bodyType;
    @ApiModelProperty(value = "新车购置价", required=true)
    BigDecimal price;
    @ApiModelProperty(value = "标的保额", required=true)
    BigDecimal si;
    @ApiModelProperty(value = "标的保费", required=true)
    BigDecimal premium;
    @ApiModelProperty(value = "险种列表", required=true)
    List<VehicleCoverageVO> vehicleCoverageVOs = new ArrayList<VehicleCoverageVO>();

    public Long getInsuredId() {
        return insuredId;
    }

    public void setInsuredId(Long insuredId) {
        this.insuredId = insuredId;
    }

    public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getVehicleBand() {
        return vehicleBand;
    }

    public void setVehicleBand(String vehicleBand) {
        this.vehicleBand = vehicleBand;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getEngineNo() {
        return engineNo;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo;
    }

    public String getCarFrameNo() {
        return carFrameNo;
    }

    public void setCarFrameNo(String carFrameNo) {
        this.carFrameNo = carFrameNo;
    }

    public String getUsageType() {
        return usageType;
    }

    public void setUsageType(String usageType) {
        this.usageType = usageType;
    }

    public String getBelongType() {
        return belongType;
    }

    public void setBelongType(String belongType) {
        this.belongType = belongType;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getSi() {
        return si;
    }

    public void setSi(BigDecimal si) {
        this.si = si;
    }

    public BigDecimal getPremium() {
        return premium;
    }

    public void setPremium(BigDecimal premium) {
        this.premium = premium;
    }

    public List<VehicleCoverageVO> getVehicleCoverageVOs() {
        return vehicleCoverageVOs;
    }

    public void setVehicleCoverageVOs(List<VehicleCoverageVO> vehicleCoverageVOs) {
        this.vehicleCoverageVOs = vehicleCoverageVOs;
    }
}
