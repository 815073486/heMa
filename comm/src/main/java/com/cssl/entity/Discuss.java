package com.cssl.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * 商品评论表类
 */
public class Discuss {
    private Integer merchantid;         //评论ID
    private Integer commid;             //商品ID
    private String loginname;           //用户名
    private String merchant;            //商品评价
    private Integer gradeid;            //好差评ID     1  好评    2  中评    3  差评
    private Double distime;             //评论时间
}
