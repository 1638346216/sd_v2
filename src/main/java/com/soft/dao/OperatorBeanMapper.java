package com.soft.dao;

import java.util.List;

import com.soft.beans.LoginBean;
import com.soft.beans.OperatorBean;
import org.springframework.stereotype.Repository;

//@Repository("operatorDao")
public interface OperatorBeanMapper {
	int deleteByPrimaryKey(String operatorId);

	int insert(OperatorBean record);

	int insertSelective(OperatorBean record);

	OperatorBean selectByPrimaryKey(String operatorId);

	int updateByPrimaryKeySelective(OperatorBean record);

	int updateByPrimaryKey(OperatorBean record);

	/**
	 * 用户的登陆方法
	 * 
	 * @param login
	 *            登陆用户信息
	 * @return 返回OperatorBean对象
	 */
	OperatorBean loginQuery(LoginBean login);

	/**
	 * 超级管理员添加操作员的或者超级管理员的方法
	 * 
	 * @param operator
	 *            要添加的管理员信息
	 * @return 返回OperatorBean对象
	 */
	OperatorBean operatorAdd(OperatorBean operator);

	/**
	 * 超级管理员添加操作员的或者超级管理员的方法
	 * 
	 * @param operator
	 *            要查询的管理员信息
	 * @return 返回查询结果集
	 */
	List<OperatorBean> operatorQuery(OperatorBean operator);

}