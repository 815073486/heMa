package com.order;

import lombok.Data;

/**
 * @ClassName Order
 * @Description TODO
 * @Author DELL
 * @Date 2020/4/25 12:01
 * @Version 1.0
 **/
@Data
public class Order {
    private int orderid;
    private String ordernum;
    private String loginname;
    private int addressid;
    private String ordertime;
    private String receivingtime;
    private int stateid;
}
