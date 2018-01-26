package com.soft.beans;

import java.io.Serializable;

/**
 * 用于映射登录信息的实体
 * 
 * @author 17117
 *
 */
public class LoginBean implements Serializable {

	/**
	 * 登录名
	 */
	private String loginName;
	/**
	 * 登录密码
	 */
	private String loginPsw;
	/**
	 * 登陆用户类型 1 ：用户 2：操作员
	 */
	private Integer loginType;
	private static final long serialVersionUID = 1L;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPsw() {
		return loginPsw;
	}

	public void setLoginPsw(String loginPsw) {
		this.loginPsw = loginPsw;
	}

	public Integer getLoginType() {
		return loginType;
	}

	public void setLoginType(Integer loginType) {
		this.loginType = loginType;
	}

}
