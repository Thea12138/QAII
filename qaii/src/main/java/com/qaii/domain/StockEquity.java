package com.qaii.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StockEquity {
    private Integer id;

    private String shareholderName;

    private String contributionAmount;

    private String contributionProportion;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date contributionTime;

    private String shareholderPosition;

    private Integer incubatorId;

    private String remark;

    private String alternativeOne;

    private String alternativeTwo;

    private String alternativeThreee;
    //这里的status是存数据库中股东表的状态码新增字段
    private int status;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date gmtCreate;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date gmtModified;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShareholderName() {
        return shareholderName;
    }

    public void setShareholderName(String shareholderName) {
        this.shareholderName = shareholderName == null ? null : shareholderName.trim();
    }

    public String getContributionAmount() {
        return contributionAmount;
    }

    public void setContributionAmount(String contributionAmount) {
        this.contributionAmount = contributionAmount == null ? null : contributionAmount.trim();
    }

    public String getContributionProportion() {
        return contributionProportion;
    }

    public void setContributionProportion(String contributionProportion) {
        this.contributionProportion = contributionProportion == null ? null : contributionProportion.trim();
    }

    public Date getContributionTime() {
        return contributionTime;
    }

    public void setContributionTime(Date contributionTime) {
        this.contributionTime = contributionTime;
    }

    public String getShareholderPosition() {
        return shareholderPosition;
    }

    public void setShareholderPosition(String shareholderPosition) {
        this.shareholderPosition = shareholderPosition == null ? null : shareholderPosition.trim();
    }

    public Integer getIncubatorId() {
        return incubatorId;
    }

    public void setIncubatorId(Integer incubatorId) {
        this.incubatorId = incubatorId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getAlternativeOne() {
        return alternativeOne;
    }

    public void setAlternativeOne(String alternativeOne) {
        this.alternativeOne = alternativeOne == null ? null : alternativeOne.trim();
    }

    public String getAlternativeTwo() {
        return alternativeTwo;
    }

    public void setAlternativeTwo(String alternativeTwo) {
        this.alternativeTwo = alternativeTwo == null ? null : alternativeTwo.trim();
    }

    public String getAlternativeThreee() {
        return alternativeThreee;
    }

    public void setAlternativeThreee(String alternativeThreee) {
        this.alternativeThreee = alternativeThreee == null ? null : alternativeThreee.trim();
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}