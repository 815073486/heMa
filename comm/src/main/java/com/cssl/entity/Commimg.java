package com.cssl.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
/**
 * 商品图片表类
 */
public class Commimg {
    private Integer commimgid;      //商品图片id
    private Integer commid;         //商品表主键
    private String img;             //图片路径
}
