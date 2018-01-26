package com.soft.model;

import java.util.List;

import com.soft.beans.LoginBean;
import com.soft.beans.OperatorBean;
import com.soft.beans.RecordBean;
import com.soft.beans.UserBean;

public interface IService {

	/**
	 * 系统登录方法
	 * 
	 * @param
	 * 
	 * @param user
	 *            登录用户名和密码
	 * @return 登录状态机类型（0：失败，1：用户，2：操作员）
	 */
	public Object login(LoginBean user);

	/**
	 * 添加管理员与操作员的方法
	 * 
	 * @param operator
	 *            要添加的操作人员实体
	 * @return 添加成功后的反馈信息
	 */
	public int operatorAdd(OperatorBean operator);

	/**
	 * 删除管理员
	 * 
	 * @param operator
	 * @return
	 */
	public int operatorDel(OperatorBean operator);

	/**
	 * 查询管理员与操作员的方法
	 * 
	 * @param operator
	 *            查询加的操作人员信息
	 * @return 添加成功后的反馈信息
	 */
	public List<OperatorBean> operatorQuery(OperatorBean operator);

	/**
	 * 修改管理员信息
	 * 
	 * @param operator
	 * @return
	 */
	public int operatorEdit(OperatorBean operator);

	/**
	 * 查询单个用户
	 * 
	 * @param userId
	 * @return
	 */
	public UserBean userQuery(String userId);

	/**
	 * 用户修改密码
	 * 
	 * @param userId
	 * @param userPsw
	 * @return
	 */
	public int userModifyPsw(String userId, String userPsw);

	/**
	 * 用户查询帐单记录
	 * 
	 * @param userId
	 * @return
	 */
	public List<RecordBean> userQureyRecord(String userId);

	/**
	 * 用户充值
	 * 
	 * @param recharge
	 * @return 1充值成功
	 */
	public int userRecharge(RecordBean recharge, String userName);

	public OperatorBean operatorQuery(String operatorId);

	/**操作员修改密码
	 * @param operatorId
	 * @param newPsw1
	 * @return
	 */
	public int operatorModifyPsw(String operatorId, String newPsw1);

	/**开户
	 * @param user
	 * @return
	 */
	public int operatorCreateUser(UserBean user);

	/**查询所有用户
	 * @return
	 */
	public List<UserBean> QueryUserList();

	public int userDelete(String userId);

	public int userModifyInfo(UserBean user);

	public int userUse(RecordBean userUse);

	public List<RecordBean> ZheXianTu(String userId);

}
