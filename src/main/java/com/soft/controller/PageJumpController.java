package com.soft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 处理页面跳转请求的响应类
 * 
 * @author 17117
 *
 */
@Controller
public class PageJumpController {

	/**
	 * 进行系统主页
	 *
	 * @return 跳转到view页面
	 */
	@RequestMapping("/")
	public String jumpLogin() {
		return "login";
	}
	/**
	 * 跳转到WEB-INF目录下的页面
	 * 
	 * @param url
	 *            目的地url
	 * @return 返回路径字符串交由视图解析器解析
	 */
	@RequestMapping("/jumpPage")
	public String jumpPage(String url) {
		return url;
	}
}
