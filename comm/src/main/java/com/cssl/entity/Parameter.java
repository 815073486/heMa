package com.cssl.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
/**
 * 商品参数表类
 */
public class Parameter {
    private Integer parameterid;        //参数ID
    private Integer commid;             //商品ID 外键引用Commodity的commid
    private String parameter;           //商品参数
    private Double price;               //商品价格
    private Integer stocknum;           //库存数量

}
