package com.soft.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.soft.beans.RecordBean;
import com.soft.beans.UserBean;
import com.soft.model.IService;

/**
 * 处理请求的响应类
 * 
 * @author 17117
 *
 */
@Controller
public class UserController {
	@Resource
	private IService service;

	@Resource
	HttpServletRequest request;
	// 用户功能分析
	/*
	 * 1、查询个人信息 ，从缓存中去取2、修改密码 3、查询账单
	 */

	/**
	 * 用户修改密码
	 */
	@ResponseBody
	@RequestMapping(value="/userModifyPsw",produces="text/html; charset=UTF-8")
	public String userModifyPsw() {
		String userId = request.getParameter("userId");
		String oldPsw = request.getParameter("oldPsw");
		String newPsw1 = request.getParameter("newPsw1");
		String newPsw2 = request.getParameter("newPsw2");
		if (newPsw1 != null && newPsw1.equals(newPsw2)) {
			UserBean user = service.userQuery(userId);
			if (user != null && user.getUserPsw().equals(oldPsw)) {
				int i = service.userModifyPsw(userId, newPsw1);
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

	/**
	 * 充值
	 */
	@ResponseBody
	@RequestMapping(value="/userRecharge",produces="text/html; charset=UTF-8")
	public String userRecharge(RecordBean recharge, String userName) {
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
			RecordBean record = recordList.get(0);
			request.getSession().setAttribute("record", record);
			// 返回充值结果
			return "充值成功，当前余额为 "+record.getRemain()+"元！";
		}
		return "充值失败，请检查账户和用户名！";
	}

	/**
	 * 查询账单
	 */
	@ResponseBody
	@RequestMapping("/userQureyRecord")
	public List<RecordBean> userQureyRecord(String userId) {
		// System.out.println(userId);
		// 要查询的用户id
		// 查询数据库
		List<RecordBean> recordList = service.userQureyRecord(userId);
		if (recordList != null && recordList.size() > 0) {
			// 将查询结果的第一条（按照时间倒序）缓存到session中显示余额
			request.getSession().setAttribute("record", recordList.get(0));
		}
		// System.out.println(recordList);
		// 返回查询结果集
		return recordList;
	}

}
