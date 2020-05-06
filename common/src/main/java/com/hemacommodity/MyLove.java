package com.hemacommodity;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName MyLove
 * @Description TODO
 * @Author DELL
 * @Date 2020/4/20 20:37
 * @Version 1.0
 **/
@Data
public class MyLove {
    private int loveid;
    private String loginname;
    private int commid;
    private Date lovetime;
}
