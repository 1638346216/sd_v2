package com.soft.dao;

import java.util.List;

import com.soft.beans.LoginBean;
import com.soft.beans.UserBean;
import org.springframework.stereotype.Repository;

//@Repository("userDao")
public interface UserBeanMapper {
	int deleteByPrimaryKey(String userId);

	int insert(UserBean record);

	int insertSelective(UserBean record);

	UserBean selectByPrimaryKey(String userId);

	int updateByPrimaryKeySelective(UserBean record);

	int updateByPrimaryKey(UserBean record);

	/**
	 * 用户的登陆方法
	 * 
	 * @param login
	 *            登陆用户信息
	 * @return 返回登录成功对象
	 */
	UserBean loginQuery(LoginBean login);

	/**
	 * 查询所有用户
	 * 
	 * @return
	 */
	List<UserBean> QueryUserList();

}