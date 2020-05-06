package com.order;

import lombok.Data;

/**
 * @ClassName Order_Comm
 * @Description TODO
 * @Author DELL
 * @Date 2020/4/25 15:24
 * @Version 1.0
 **/
@Data
public class Order_Comm {
    private int ocid;
    private String ordernum;
    private int commid;
    private String commname;
    private String commimg;
    private int ordercommsum;
    private String odert_comm_summoney;
    private String loginname;
}
