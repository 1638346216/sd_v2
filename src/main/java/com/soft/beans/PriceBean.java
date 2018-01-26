package com.soft.beans;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author 
 */
public class PriceBean implements Serializable {
    /**
     * 电费价格
     */
    private BigDecimal elecPrice;

    private static final long serialVersionUID = 1L;

    public BigDecimal getElecPrice() {
        return elecPrice;
    }

    public void setElecPrice(BigDecimal elecPrice) {
        this.elecPrice = elecPrice;
    }
}