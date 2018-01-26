package com.soft.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.soft.beans.OperatorBean;
import com.soft.beans.RecordBean;
import com.soft.beans.UserBean;
import com.soft.beans.UserInfo;
import com.soft.model.IService;
import com.soft.utils.MyUtils;

@Controller
public class OperatorController {
	@Resource
	private IService service;

	@Resource
	HttpServletRequest request;
	/*
	 * 操作员功能分析 1、修改密码 2、增删改查用户 3、电费充值 4、发布动态（如何实现）
	 * 
	 */

	/**
	 * 操作员修改密码
	 */
	@ResponseBody
	@RequestMapping(value = "/operatorModifyPsw", produces = "text/html; charset=UTF-8")
	public String operatorModifyPsw() {
		String operatorId = request.getParameter("operatorId");
		String oldPsw = request.getParameter("oldPsw");
		String newPsw1 = request.getParameter("newPsw1");
		String newPsw2 = request.getParameter("newPsw2");
		if (newPsw1 != null && newPsw1.equals(newPsw2)) {
			OperatorBean operator = service.operatorQuery(operatorId);
			if (operator != null && operator.getOperatorPsw().equals(oldPsw)) {
				int i = service.operatorModifyPsw(operatorId, newPsw1);
				if (i > 0) {
					return "修改成功！";

				} else {
					return "服务器响应错误！";
				}
			} else {
				return "原密码输入错误！";
			}

		} else {
			return "两次输入的密码不一致！";
		}
	}

	/*
	 * 开户
	 */
	@ResponseBody
	@RequestMapping(value = "/operatorCreateUser", produces = "text/html; charset=UTF-8")
	public String operatorCreateUser(UserBean user) {
		int i = service.operatorCreateUser(user);
		if (i > 0) {
			return "开户成功";
		} else {
			return "开户失败";
		}
	}

	/*
	 * 查询所有用户
	 * 
	 */
	@ResponseBody
	@RequestMapping("/operatorQueryUserList")
	public List<UserBean> operatorQueryUserList() {
		List<UserBean> userList = service.QueryUserList();
		return userList;

	}

	/*
	 * 查询单个用户
	 */
	@RequestMapping("/userModifyQuery")
	public String userModifyQuery(String userId) {
		UserBean user = service.userQuery(userId);
		request.getSession().setAttribute("user", user);
		return "operator/ModifyUser";
	}

	/*
	 * 注销单个用户
	 */
	@ResponseBody
	@RequestMapping(value = "/userDelete", produces = "text/html; charset=UTF-8")
	public String userDelete(String userId) {
		int i = service.userDelete(userId);
		if (i > 0) {
			return "删除成功！";
		}
		return "删除失败！";
	}

	/*
	 * 查询单个用户+余额
	 */
	@ResponseBody
	@RequestMapping("/operatorQueryUser")
	public UserInfo operatorQueryUser(String userId) {
		// 查询用户
		UserBean user = service.userQuery(userId);
		if (user != null) {
			// 创建返回对象
			UserInfo userInfo = MyUtils.getNewInstance(UserInfo.class);
			// 将user放到返回对象中
			userInfo.setUserBean(user);
			List<RecordBean> record = service.userQureyRecord(userId);
			if (record != null && record.size() > 0) {
				request.getSession().setAttribute("user", user);
				userInfo.setRemain(record.get(0).getRemain());
			}
			return userInfo;
		}
		return null;
	}

	/*
	 * 充值
	 */
	/**
	 * 充值
	 */
	// 此方法和用户充值方法一致，可优化
	@ResponseBody
	@RequestMapping(value = "/operatorRechargeUser", produces = "text/html; charset=UTF-8")
	public String operatorRechargeUser(RecordBean recharge, String userName) {
		// 带有操作员信息
		// 如果充值的金额有误，直接返回错误
		// 注意BigDecimal比较大小
		if (recharge.getMoney() == null || recharge.getMoney().compareTo(new BigDecimal(0)) <= 0) {
			return "请输入正确的金额！";
		}
		// 调用充值方法进行充值操作
		int i = service.userRecharge(recharge, userName);
		if (i > 0) {
			// 充值成功后将余额查询缓存到session中
			List<RecordBean> recordList = service.userQureyRecord(recharge.getUserId());
			request.getSession().setAttribute("record", recordList.get(0));
			// 返回充值结果
			return "success";
		}
		return "充值意外！";
	}

	/**
	 * 修改用户
	 * 
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/ModifyUser", produces = "text/html; charset=UTF-8")
	public String ModifyUser(UserBean user) {
		// 调用简单的修改方法，返回修改状态
		int i = service.userModifyInfo(user);
		if (i > 0) {
			return "修改成功！";
		}
		return "修改失败！";
	}
	
	@ResponseBody
	@RequestMapping("ZheXianTu")
	public List<RecordBean> ZheXianTu(String userId){
		List<RecordBean> list = service.ZheXianTu(userId);
		
		return list;
		
	}
	

}
