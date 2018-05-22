package com.coral.cgs.model.vehicle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;


@ApiModel(description= "车险利益项模型")
public class VehicleBenefitVO implements Serializable {

    @ApiModelProperty(value = "车险利益项ID", required=true)
    Long benefitId;
    @ApiModelProperty(value = "利益项名称", required=true)
    String benefitName;
    @ApiModelProperty(value = "利益项保额", required=true)
    BigDecimal si;
    @ApiModelProperty(value = "利益项保费", required=true)
    BigDecimal premium;
    @ApiModelProperty(value = "利益项限额", required=true)
    BigDecimal limit;
    @ApiModelProperty(value = "免赔额", required=true)
    BigDecimal deduction;

    public Long getBenefitId() {
        return benefitId;
    }

    public void setBenefitId(Long benefitId) {
        this.benefitId = benefitId;
    }

    public String getBenefitName() {
        return benefitName;
    }

    public void setBenefitName(String benefitName) {
        this.benefitName = benefitName;
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

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }

    public BigDecimal getDeduction() {
        return deduction;
    }

    public void setDeduction(BigDecimal deduction) {
        this.deduction = deduction;
    }
}
