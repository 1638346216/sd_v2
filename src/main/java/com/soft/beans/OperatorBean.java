package com.soft.beans;

import java.io.Serializable;

/**
 * @author 
 */
public class OperatorBean implements Serializable {
    /**
     * 操作员编码，用于登录
     */
    private String operatorId;

    /**
     * 操作员姓名
     */
    private String operatorName;

    /**
     * 操作员密码
     */
    private String operatorPsw;

    /**
     * 操作员类型，1： 超级，0 ：普通
     */
    private String isSuper;

    private static final long serialVersionUID = 1L;

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getOperatorPsw() {
        return operatorPsw;
    }

    public void setOperatorPsw(String operatorPsw) {
        this.operatorPsw = operatorPsw;
    }

    public String getIsSuper() {
        return isSuper;
    }

    public void setIsSuper(String isSuper) {
        this.isSuper = isSuper;
    }
}