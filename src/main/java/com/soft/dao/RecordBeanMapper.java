package com.soft.dao;

import java.util.List;

import com.soft.beans.RecordBean;
import org.springframework.stereotype.Repository;

//@Repository("recordDao")
public interface RecordBeanMapper {
	int deleteByPrimaryKey(Integer recordId);

	int insert(RecordBean record);

	int insertSelective(RecordBean record);

	RecordBean selectByPrimaryKey(Integer recordId);

	int updateByPrimaryKeySelective(RecordBean record);

	int updateByPrimaryKey(RecordBean record);

	/**
	 * 用户查询账单
	 * 
	 * @param userId
	 * @return
	 */
	List<RecordBean> queryRecord(String userId);

	List<RecordBean> select4ZheXianTu(String userId);
	/**
	 * 充值
	 * 
	 * @param record
	 * @return
	 */
	//int userRecharge(RecordBean record);


}