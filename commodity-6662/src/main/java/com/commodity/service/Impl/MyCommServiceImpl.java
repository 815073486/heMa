package com.commodity.service.Impl;

import com.commodity.dao.MyCommDao;
import com.commodity.service.MyCommService;
import com.hemacommodity.MyCar;
import com.hemacommodity.MyLove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName MyCommServiceImpl
 * @Description TODO
 * @Author DELL
 * @Date 2020/4/20 20:43
 * @Version 1.0
 **/
@Service
public class MyCommServiceImpl implements MyCommService {
    @Autowired
    private MyCommDao md;
    @Override
    public int myLove(MyLove love) {
        if(fadeByid(love)>0){
            return md.updateTime(love);
        }else{
            return md.myLove(love);
        }
    }

    @Override
    public List<Map<String, Object>> loveFall(String loginname) {
        return md.loveFall(loginname);
    }

    @Override
    public int fadeByid(MyLove love) {
        return md.fadeByid(love);
    }

    @Override
    public int updateTime(MyLove love) {
        return md.updateTime(love);
    }

    @Override
    public int delLoveById(int loveid) {
        return md.delLoveById(loveid);
    }

    @Override
    public int delLoveFall(String loginname) {
        return md.delLoveFall(loginname);
    }

    @Override
    public int insertCar(MyCar car) {
        if(carParCount(car)>0){
            return md.uptSum(car);
        }else{
            return md.insertCar(car);
        }

    }

    @Override
    public int carParCount(MyCar car) {
        return md.carParCount(car);
    }

    @Override
    public int uptSum(MyCar car) {
        return md.uptSum(car);
    }

    @Override
    public List<Map<String, Object>> carFadeAll(String loginname) {
        return md.carFadeAll(loginname);
    }

    @Override
    public String totalMoney(String uname) {
        return md.totalMoney(uname);
    }

    @Override
    public int delCar(int cid) {
        return md.delCar(cid);
    }

    @Override
    public Map<String,Object> uptCarCommSum(MyCar car) {
        if(md.uptCarCommSum(car)>0){
            Map<String,Object> moneyMap=new HashMap<>();
            moneyMap.put("byIdMoney",totalMoneyFadeById(car));
            moneyMap.put("sumMoney",totalMoney(car.getLoginname()));
            return moneyMap;
        }
        return null;
    }

    @Override
    public String totalMoneyFadeById(MyCar car) {
        return md.totalMoneyFadeById(car);
    }

    @Override
    public Map<String, Object> carFadeByID(int carid) {
        return md.carFadeByID(carid);
    }
}
