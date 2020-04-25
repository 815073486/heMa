package com.cssl.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * 分类表类
 */
public class Classify {
    private Integer classifyid;         //商品分类id
    private String classifyname;        //商品分类名称
    private Integer fatherid;           //商品分类父id
}
