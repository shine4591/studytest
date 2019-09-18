package com.andy.user.model;

import java.math.BigDecimal;
import java.util.Date;

public class DailyNode {
    private Integer id;

    private Integer tradedate;

    private Integer stockcode;

    private String stockname;

    private BigDecimal closeprice;

    private BigDecimal maxprice;

    private BigDecimal minprice;

    private BigDecimal openprice;

    private BigDecimal prevclose;

    private BigDecimal changeamount;

    private BigDecimal changepercent;

    private BigDecimal changerate;

    private Long volumn;

    private BigDecimal turnover;

    private BigDecimal totalmarketvalue;

    private BigDecimal circlemarketvalue;

    private Date createtime;

    private Date lasttime;

    public DailyNode(Integer id, Integer tradedate, Integer stockcode, String stockname, BigDecimal closeprice, BigDecimal maxprice, BigDecimal minprice, BigDecimal openprice, BigDecimal prevclose, BigDecimal changeamount, BigDecimal changepercent, BigDecimal changerate, Long volumn, BigDecimal turnover, BigDecimal totalmarketvalue, BigDecimal circlemarketvalue, Date createtime, Date lasttime) {
        this.id = id;
        this.tradedate = tradedate;
        this.stockcode = stockcode;
        this.stockname = stockname;
        this.closeprice = closeprice;
        this.maxprice = maxprice;
        this.minprice = minprice;
        this.openprice = openprice;
        this.prevclose = prevclose;
        this.changeamount = changeamount;
        this.changepercent = changepercent;
        this.changerate = changerate;
        this.volumn = volumn;
        this.turnover = turnover;
        this.totalmarketvalue = totalmarketvalue;
        this.circlemarketvalue = circlemarketvalue;
        this.createtime = createtime;
        this.lasttime = lasttime;
    }

    public static void main(String[] args) {
        System.out.println(11);
    }

    public DailyNode() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTradedate() {
        return tradedate;
    }

    public void setTradedate(Integer tradedate) {
        this.tradedate = tradedate;
    }

    public Integer getStockcode() {
        return stockcode;
    }

    public void setStockcode(Integer stockcode) {
        this.stockcode = stockcode;
    }

    public String getStockname() {
        return stockname;
    }

    public void setStockname(String stockname) {
        this.stockname = stockname == null ? null : stockname.trim();
    }

    public BigDecimal getCloseprice() {
        return closeprice;
    }

    public void setCloseprice(BigDecimal closeprice) {
        this.closeprice = closeprice;
    }

    public BigDecimal getMaxprice() {
        return maxprice;
    }

    public void setMaxprice(BigDecimal maxprice) {
        this.maxprice = maxprice;
    }

    public BigDecimal getMinprice() {
        return minprice;
    }

    public void setMinprice(BigDecimal minprice) {
        this.minprice = minprice;
    }

    public BigDecimal getOpenprice() {
        return openprice;
    }

    public void setOpenprice(BigDecimal openprice) {
        this.openprice = openprice;
    }

    public BigDecimal getPrevclose() {
        return prevclose;
    }

    public void setPrevclose(BigDecimal prevclose) {
        this.prevclose = prevclose;
    }

    public BigDecimal getChangeamount() {
        return changeamount;
    }

    public void setChangeamount(BigDecimal changeamount) {
        this.changeamount = changeamount;
    }

    public BigDecimal getChangepercent() {
        return changepercent;
    }

    public void setChangepercent(BigDecimal changepercent) {
        this.changepercent = changepercent;
    }

    public BigDecimal getChangerate() {
        return changerate;
    }

    public void setChangerate(BigDecimal changerate) {
        this.changerate = changerate;
    }

    public Long getVolumn() {
        return volumn;
    }

    public void setVolumn(Long volumn) {
        this.volumn = volumn;
    }

    public BigDecimal getTurnover() {
        return turnover;
    }

    public void setTurnover(BigDecimal turnover) {
        this.turnover = turnover;
    }

    public BigDecimal getTotalmarketvalue() {
        return totalmarketvalue;
    }

    public void setTotalmarketvalue(BigDecimal totalmarketvalue) {
        this.totalmarketvalue = totalmarketvalue;
    }

    public BigDecimal getCirclemarketvalue() {
        return circlemarketvalue;
    }

    public void setCirclemarketvalue(BigDecimal circlemarketvalue) {
        this.circlemarketvalue = circlemarketvalue;
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