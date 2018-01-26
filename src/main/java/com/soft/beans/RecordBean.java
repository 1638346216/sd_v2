package com.soft.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 
 */
public class RecordBean implements Serializable {
    /**
     * 自增主键,流水编号
     */
    private String recordId;

    /**
     * 用户编号
     */
    private String userId;

    /**
     * 前一天所用电量
     */
    private Double used;

    /**
     * 流水金额，+充值，-消费
     */
    private BigDecimal money;

    /**
     * 操作时间
     */
    private Date modiTime;

    /**
     * 剩余电费
     */
    private BigDecimal remain;

    /**
     * 操作员
     */
    private String operatorId;

    private static final long serialVersionUID = 1L;

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Double getUsed() {
        return used;
    }

    public void setUsed(Double used) {
        this.used = used;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Date getModiTime() {
        return modiTime;
    }

    public void setModiTime(Date modiTime) {
        this.modiTime = modiTime;
    }

    public BigDecimal getRemain() {
        return remain;
    }

    public void setRemain(BigDecimal remain) {
        this.remain = remain;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }
}