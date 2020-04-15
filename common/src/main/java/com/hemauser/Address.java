package com.hemauser;

import lombok.Data;

/**
 * 用户收货地址管理类
 *
 * @ClassName Address
 * @Description TODO
 * @Author DELL
 * @Date 2020/4/9 17:52
 * @Version 1.0
 **/
@Data
public class Address {
    private Integer addressid;
    private String loginname;
    private String consignee;
    private String consigneephone;
    private String addressname;
}
