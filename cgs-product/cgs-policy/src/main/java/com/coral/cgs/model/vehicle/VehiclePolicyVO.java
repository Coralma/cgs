package com.coral.cgs.model.vehicle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ccc on 2018/5/17.
 */
@ApiModel(description= "车险保单模型")
public class VehiclePolicyVO implements Serializable {

    @ApiModelProperty(value = "保单ID", required=true)
    Long policyId;
    @ApiModelProperty(value = "保单号", required=true)
    String policyNo;
    @ApiModelProperty(value = "生效日期", required=true)
    Date effectiveDate;
    @ApiModelProperty(value = "失效日期", required=true)
    Date expiryDate;
    @ApiModelProperty(value = "保单状态", required=true)
    String status;

    @ApiModelProperty(value = "保单持有人姓名", required=true)
    String policyHolderName;
    @ApiModelProperty(value = "性别", required=true)
    String gender;
    @ApiModelProperty(value = "出生日期", required=true)
    Date birthday;
    @ApiModelProperty(value = "证件类型", required=true)
    String idType;
    @ApiModelProperty(value = "证件号码", required=true)
    String idNo;
    @ApiModelProperty(value = "邮寄地址", required=true)
    String address;
    @ApiModelProperty(value = "邮编", required=true)
    String postNo;
    @ApiModelProperty(value = "手机", required=true)
    String mobilePhone;
    @ApiModelProperty(value = "公司电话")
    String companyPhone;
    @ApiModelProperty(value = "家庭电话")
    String homePhone;

    @ApiModelProperty(value = "保单总保额", required=true)
    BigDecimal si;
    @ApiModelProperty(value = "保单总保费", required=true)
    BigDecimal premium;

    @ApiModelProperty(value = "保单标的", required=true)
    List<VehicleInsuredVO> vehicleInsuredVOs = new ArrayList<VehicleInsuredVO>();

    public Long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Long policyId) {
        this.policyId = policyId;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getPolicyHolderName() {
        return policyHolderName;
    }

    public void setPolicyHolderName(String policyHolderName) {
        this.policyHolderName = policyHolderName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostNo() {
        return postNo;
    }

    public void setPostNo(String postNo) {
        this.postNo = postNo;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
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

    public List<VehicleInsuredVO> getVehicleInsuredVOs() {
        return vehicleInsuredVOs;
    }

    public void setVehicleInsuredVOs(List<VehicleInsuredVO> vehicleInsuredVOs) {
        this.vehicleInsuredVOs = vehicleInsuredVOs;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
