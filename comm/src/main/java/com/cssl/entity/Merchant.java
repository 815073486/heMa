package com.cssl.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
/**
 * 商家表类
 */
public class Merchant {
    private Integer merchantid;         //商家ID
    private String merchantname;        //商家名称
    private String merchantadd;         //商家地址
    private Integer fixturenum;         //商家成交数
    private Double grade;               //商家评分
}
