package com.soft.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.soft.beans.LoginBean;
import com.soft.beans.OperatorBean;
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
public class RequestController {
	@Resource
	private IService service;

	@Resource
	HttpServletRequest request;

	/**
	 * 响应doLogin登录请求的方法
	 * 
	 * @return 视图路径,去掉前缀和后缀
	 */
	@RequestMapping("/doLogin")
	public String doLogin(LoginBean user) {
		// 输出客户端传过来的用户名和密码和类型(1：用户，2：操作员)
		System.out.println("user : " + user.getLoginName());
		System.out.println("psw : " + user.getLoginPsw());
		System.out.println("type : " + user.getLoginType());
		// 调用登录方法
		Object login = service.login(user);
		if (login != null) {
			if (login instanceof UserBean) {
				request.getSession().setAttribute("user", login);
				List<RecordBean> recordList = service.userQureyRecord(((UserBean) login).getUserId());
				if (recordList != null && recordList.size() > 0) {
					// 将查询结果的第一条（按照时间倒序）缓存到session中显示余额
					request.getSession().setAttribute("record", recordList.get(0));
				}
				System.out.println("用户登录");
				return "user/userMain";
			} else {
				OperatorBean operator = (OperatorBean) login;
				request.getSession().setAttribute("operator", login);
				System.out.println("操作员登录");
				if ("1".equals(operator.getIsSuper())) {
					return "super/superMain";
				}
				request.getSession().setAttribute("operator", login);
				return "operator/operatorMain";
			}
		} else {
			return "../../Login";
		}

	}

	@ResponseBody
	@RequestMapping(value = "/userUse", produces = "text/html; charset=UTF-8")
	public String userUse(RecordBean userUse) {

		if (userUse.getUsed() == null || userUse.getUsed() <= 0) {
			return "请输入正确的用电量！";
		}
		// 调用充值方法进行充值操作
		int i = service.userUse(userUse);
		if (i > 0) {
			// 充值成功后将余额查询缓存到session中
			List<RecordBean> recordList = service.userQureyRecord(userUse.getUserId());
			request.getSession().setAttribute("record", recordList.get(0));
			// 返回充值结果
			return "success";
		}
		return "充值意外！";

	}

}
