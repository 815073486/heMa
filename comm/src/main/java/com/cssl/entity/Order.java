package com.cssl.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Order {
    private Integer orderid;
    private String ordernum;
    private String loginname;
    private Integer addressid;
    private String ordertime;
    private Date receivingtime;
    private Integer stateid;
}
