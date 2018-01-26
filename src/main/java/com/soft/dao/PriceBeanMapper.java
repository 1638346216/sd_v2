package com.soft.dao;

import com.soft.beans.PriceBean;
import org.springframework.stereotype.Repository;

//@Repository("priceDao")
public interface PriceBeanMapper {
	Double price();
    int insert(PriceBean record);

    int insertSelective(PriceBean record);
}