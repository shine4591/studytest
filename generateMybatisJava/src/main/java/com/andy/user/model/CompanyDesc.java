package com.andy.user.model;

import java.math.BigDecimal;
import java.util.Date;

public class CompanyDesc {
    private Integer id;

    private Integer stockcode;

    private String region;

    private String concept;

    private String business;

    private Integer listingdate;

    private BigDecimal assetpershare;

    private BigDecimal earnspershare;

    private BigDecimal profit;

    private BigDecimal profitgrowth;

    private BigDecimal income;

    private BigDecimal cashflowpershare;

    private BigDecimal fundpershare;

    private BigDecimal undisprofitpershare;

    private Long totalcapital;

    private Long publiccapital;

    private Date createtime;

    private Date lasttime;

    public CompanyDesc(Integer id, Integer stockcode, String region, String concept, String business, Integer listingdate, BigDecimal assetpershare, BigDecimal earnspershare, BigDecimal profit, BigDecimal profitgrowth, BigDecimal income, BigDecimal cashflowpershare, BigDecimal fundpershare, BigDecimal undisprofitpershare, Long totalcapital, Long publiccapital, Date createtime, Date lasttime) {
        this.id = id;
        this.stockcode = stockcode;
        this.region = region;
        this.concept = concept;
        this.business = business;
        this.listingdate = listingdate;
        this.assetpershare = assetpershare;
        this.earnspershare = earnspershare;
        this.profit = profit;
        this.profitgrowth = profitgrowth;
        this.income = income;
        this.cashflowpershare = cashflowpershare;
        this.fundpershare = fundpershare;
        this.undisprofitpershare = undisprofitpershare;
        this.totalcapital = totalcapital;
        this.publiccapital = publiccapital;
        this.createtime = createtime;
        this.lasttime = lasttime;
    }

    public CompanyDesc() {
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept == null ? null : concept.trim();
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business == null ? null : business.trim();
    }

    public Integer getListingdate() {
        return listingdate;
    }

    public void setListingdate(Integer listingdate) {
        this.listingdate = listingdate;
    }

    public BigDecimal getAssetpershare() {
        return assetpershare;
    }

    public void setAssetpershare(BigDecimal assetpershare) {
        this.assetpershare = assetpershare;
    }

    public BigDecimal getEarnspershare() {
        return earnspershare;
    }

    public void setEarnspershare(BigDecimal earnspershare) {
        this.earnspershare = earnspershare;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public BigDecimal getProfitgrowth() {
        return profitgrowth;
    }

    public void setProfitgrowth(BigDecimal profitgrowth) {
        this.profitgrowth = profitgrowth;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public BigDecimal getCashflowpershare() {
        return cashflowpershare;
    }

    public void setCashflowpershare(BigDecimal cashflowpershare) {
        this.cashflowpershare = cashflowpershare;
    }

    public BigDecimal getFundpershare() {
        return fundpershare;
    }

    public void setFundpershare(BigDecimal fundpershare) {
        this.fundpershare = fundpershare;
    }

    public BigDecimal getUndisprofitpershare() {
        return undisprofitpershare;
    }

    public void setUndisprofitpershare(BigDecimal undisprofitpershare) {
        this.undisprofitpershare = undisprofitpershare;
    }

    public Long getTotalcapital() {
        return totalcapital;
    }

    public void setTotalcapital(Long totalcapital) {
        this.totalcapital = totalcapital;
    }

    public Long getPubliccapital() {
        return publiccapital;
    }

    public void setPubliccapital(Long publiccapital) {
        this.publiccapital = publiccapital;
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