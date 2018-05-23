package com.coral.cgs.model.vehicle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@ApiModel(description= "车险险种模型")
public class VehicleCoverageVO implements Serializable {

    @ApiModelProperty(value = "车险险种ID", required=true)
    Long coverageId;
    @ApiModelProperty(value = "车险险种名称", required=true)
    String coverageName;
    @ApiModelProperty(value = "是否是强制险种（1表示强制，0表示非强制）", required=true)
    Integer compulsive = 0;
    @ApiModelProperty(value = "是否是主险种（1表示主险，2表示附加险）", required=true)
    Integer primary = 0;
    @ApiModelProperty(value = "险种保额", required=true)
    BigDecimal si;
    @ApiModelProperty(value = "险种保费", required=true)
    BigDecimal premium;
    @ApiModelProperty(value = "险种利益项", required=true)
    List<VehicleBenefitVO> vehicleBenefitVOs = new ArrayList<VehicleBenefitVO>();

    public Long getCoverageId() {
        return coverageId;
    }

    public void setCoverageId(Long coverageId) {
        this.coverageId = coverageId;
    }

    public String getCoverageName() {
        return coverageName;
    }

    public void setCoverageName(String coverageName) {
        this.coverageName = coverageName;
    }

    public Integer getCompulsive() {
        return compulsive;
    }

    public void setCompulsive(Integer compulsive) {
        this.compulsive = compulsive;
    }

    public Integer getPrimary() {
        return primary;
    }

    public void setPrimary(Integer primary) {
        this.primary = primary;
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

    public List<VehicleBenefitVO> getVehicleBenefitVOs() {
        return vehicleBenefitVOs;
    }

    public void setVehicleBenefitVOs(List<VehicleBenefitVO> vehicleBenefitVOs) {
        this.vehicleBenefitVOs = vehicleBenefitVOs;
    }
}
