package com.cssl.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Hemauser {
    private Integer userid;
    private String loginname;
    private String userpwd;
    private Integer intergral;
    private Date joindate;
    private Integer statusid;
    private Integer gradeid;
}
