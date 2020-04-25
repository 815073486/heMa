package com.cssl.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
/**
 * 商品表类
 */
public class Commodity {
    @TableId(value = "commid")                     //这里要映射到当前实体类的主键   重点
    private Integer commid;         //商品id
    private String commname;        //商品名称
    private Integer classifyid;     //分类表的主键
    private Integer merchantid;     //商家表的主键
    private Date commtime;          //添加商品时间   系统默认当前时间
    private String commimg;         //商品图片
    private Integer rush;           //是否热卖
    private String presentation;    //商品介绍
    private Integer sales;          //销售数量
}
