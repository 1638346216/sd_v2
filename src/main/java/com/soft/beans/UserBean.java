package com.soft.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class UserBean implements Serializable {
    /**
     * 唯一标识，登录名
     */
    private String userId;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户登录密码
     */
    private String userPsw;

    /**
     * 用户性别
     */
    private String userSex;

    /**
     * 用户电话，登录名
     */
    private String userTel;

    /**
     * 身份证号
     */
    private String userCard;

    /**
     * 用户城市
     */
    private String userCity;

    /**
     * 用户区域
     */
    private String userArea;

    /**
     * 用户详细地址
     */
    private String userDetailAddr;

    /**
     * 开户时间
     */
    private Date userCreate;

    private static final long serialVersionUID = 1L;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPsw() {
        return userPsw;
    }

    public void setUserPsw(String userPsw) {
        this.userPsw = userPsw;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserCard() {
        return userCard;
    }

    public void setUserCard(String userCard) {
        this.userCard = userCard;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getUserArea() {
        return userArea;
    }

    public void setUserArea(String userArea) {
        this.userArea = userArea;
    }

    public String getUserDetailAddr() {
        return userDetailAddr;
    }

    public void setUserDetailAddr(String userDetailAddr) {
        this.userDetailAddr = userDetailAddr;
    }

    public Date getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(Date userCreate) {
        this.userCreate = userCreate;
    }
}