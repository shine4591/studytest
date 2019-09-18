package com.andy.user.model;

import java.math.BigDecimal;
import java.util.Date;

public class BonusPlan {
    private Integer id;

    private Integer stockcode;

    private Integer publishdate;

    private Integer year;

    private Integer baseamount;

    private Integer give;

    private Integer increase;

    private BigDecimal interest;

    private Integer recorddate;

    private Integer dividedate;

    private Integer bonusdate;

    private Date createtime;

    private Date lasttime;

    public BonusPlan(Integer id, Integer stockcode, Integer publishdate, Integer year, Integer baseamount, Integer give, Integer increase, BigDecimal interest, Integer recorddate, Integer dividedate, Integer bonusdate, Date createtime, Date lasttime) {
        this.id = id;
        this.stockcode = stockcode;
        this.publishdate = publishdate;
        this.year = year;
        this.baseamount = baseamount;
        this.give = give;
        this.increase = increase;
        this.interest = interest;
        this.recorddate = recorddate;
        this.dividedate = dividedate;
        this.bonusdate = bonusdate;
        this.createtime = createtime;
        this.lasttime = lasttime;
    }

    public BonusPlan() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStockcode() {
        return stockcode;
    }

    public void setStockcode(Integer stockcode) {
        this.stockcode = stockcode;
    }

    public Integer getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(Integer publishdate) {
        this.publishdate = publishdate;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getBaseamount() {
        return baseamount;
    }

    public void setBaseamount(Integer baseamount) {
        this.baseamount = baseamount;
    }

    public Integer getGive() {
        return give;
    }

    public void setGive(Integer give) {
        this.give = give;
    }

    public Integer getIncrease() {
        return increase;
    }

    public void setIncrease(Integer increase) {
        this.increase = increase;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public Integer getRecorddate() {
        return recorddate;
    }

    public void setRecorddate(Integer recorddate) {
        this.recorddate = recorddate;
    }

    public Integer getDividedate() {
        return dividedate;
    }

    public void setDividedate(Integer dividedate) {
        this.dividedate = dividedate;
    }

    public Integer getBonusdate() {
        return bonusdate;
    }

    public void setBonusdate(Integer bonusdate) {
        this.bonusdate = bonusdate;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getLasttime() {
        return lasttime;
    }

    public void setLasttime(Date lasttime) {
        this.lasttime = lasttime;
    }
}