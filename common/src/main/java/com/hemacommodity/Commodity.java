package com.hemacommodity;

import lombok.Data;

/**
 * @ClassName Commodity
 * @Description TODO
 * @Author DELL
 * @Date 2020/4/17 21:45
 * @Version 1.0
 **/
@Data
public class Commodity {
   private int commid;
   private String commname;
   private int classifyid;
   private int merchantid;
   private int rush;
   private String commimg;
   private String commtime;
   private int sales;
   private Double price;

}
