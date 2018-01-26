package com.soft.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.soft.beans.OperatorBean;
import com.soft.model.IService;

/**
 * 处理超级管理员的请求的响应类
 * 
 * @author 17117
 *
 */
@Controller
public class SuperController {

	@Resource
	private IService service;

	@Resource
	HttpServletRequest request;

	/**
	 * 响应查询管理员和超级管理员的方法
	 * 
	 * @param operator
	 *            要查询的管理员信息
	 * @return 返回查询结果集
	 */
	@ResponseBody
	@RequestMapping("/operatorQuery")
	public List<OperatorBean> operatorQuery(OperatorBean operator) {
		// 查询管理员列表
		List<OperatorBean> list = service.operatorQuery(operator);
		//返回查询结果
		return list;
	}

	/**
	 * 管理员的增删改查
	 * @param operator 接受表单信息
	 * @param type 接受操作类型
	 * @return 返回操作结果
	 */
	@ResponseBody
	@RequestMapping("/superAction")
	public String superAction(OperatorBean operator, @RequestParam("oper") String type) {
		//数据库操作结果状态
		int i = 0;
		//判断操作状态
		if ("add".equals(type)) {
			i = service.operatorAdd(operator);
			if (i > 0) {
				// 添加成功缓存信息到session中
				// request.getSession().setAttribute("operatorBean", operator);
				// 前端验证返回字符串决定是否从session取值
				return "添加成功";
			} else {
				return "添加失败";
			}
		} else if ("edit".equals(type)) {
			i = service.operatorEdit(operator);
			if (i > 0) {
				return "修改成功";
			} else {
				return "修改失败";
			}
		} else {
			i = service.operatorDel(operator);
			if (i > 0) {
				return null;
			} else {
				return null;
			}
		}
	}

}
