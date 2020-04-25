package com.cssl.entity;

import lombok.Data;

@Data
/**
 * 后台用户表类
 */
public class Admininfo {
    private Integer aid;            //用户ID
    private String aname;           //用户名
    private String apassword;       //用户密码
    private Integer atype;          //用户类型
}
