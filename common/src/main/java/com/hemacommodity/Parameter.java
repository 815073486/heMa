package com.hemacommodity;

import lombok.Data;

/**
 * @ClassName Parameter
 * @Description TODO
 * @Author DELL
 * @Date 2020/4/17 21:48
 * @Version 1.0
 **/
@Data
public class Parameter {
    private int parameterid;
    private int commid;
    private String parameter;
    private double price;
    private int stocknum;
}
