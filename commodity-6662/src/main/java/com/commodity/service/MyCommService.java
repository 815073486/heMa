package com.commodity.service;

import com.hemacommodity.MyCar;
import com.hemacommodity.MyLove;

import java.util.List;
import java.util.Map;

public interface MyCommService {
    public int myLove(MyLove love);
    public List<Map<String,Object>> loveFall(String loginname);
    public  int fadeByid(MyLove love);
    public int updateTime(MyLove love);
    public int delLoveById(int loveid);
    public int delLoveFall(String loginname);
    public int insertCar(MyCar car);
    public int carParCount(MyCar car); //查看购物车列表中是否存在次参数的商品
    public int uptSum(MyCar car);//如果存在次参数商品 修改其数量
    public List<Map<String,Object>> carFadeAll(String loginname);//查看购物车
    public String totalMoney(String uname);//查看用户的购物车总金额
    public int delCar(int cid);//删除购物车商品
    public Map<String,Object> uptCarCommSum(MyCar car);
    public String totalMoneyFadeById(MyCar car);//用来查询修改购物车商品的数量后，单列总价
    public Map<String,Object> carFadeByID(int carid);//根据购物车编号查询商品信息
}
