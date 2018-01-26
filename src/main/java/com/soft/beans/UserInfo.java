package com.soft.beans;

import java.math.BigDecimal;

public class UserInfo {

	private UserBean userBean;
	private BigDecimal remain;

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public BigDecimal getRemain() {
		return remain;
	}

	public void setRemain(BigDecimal remain) {
		this.remain = remain;
	}

}
