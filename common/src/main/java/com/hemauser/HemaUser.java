package com.hemauser;

import lombok.Data;

/**
 * 用户详情实体类
 *
 * @ClassName HemaUser
 * @Description TODO
 * @Author DELL
 * @Date 2020/4/9 17:49
 * @Version 1.0
 **/
@Data
public class HemaUser {
    private Integer userid;
    private String loginname;
    private String userpwd;
    private Integer intergral;
    private String joindate;
    private Integer statusid;
    private Integer gradeid;
    private int yzm;

}
