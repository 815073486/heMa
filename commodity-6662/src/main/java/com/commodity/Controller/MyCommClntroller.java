package com.commodity.Controller;

import com.commodity.service.MyCommService;
import com.hemacommodity.MyCar;
import com.hemacommodity.MyLove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @ClassName MyCommClntroller
 * @Description TODO
 * @Author DELL
 * @Date 2020/4/20 20:44
 * @Version 1.0
 **/
@RestController
public class MyCommClntroller {
    @Autowired
    private MyCommService ms;

    @RequestMapping("/myLove")
    public int myLove(@RequestBody MyLove love){
        return ms.myLove(love);
    }

    @RequestMapping("/loveFall")
    public List<Map<String,Object>> loveFall(String loginname){
        return ms.loveFall(loginname);
    }

    @RequestMapping("/delLoveById")
    public int delLoveById(int loveid){
        return ms.delLoveById(loveid);
    }

    @RequestMapping("/delLoveFall")
    public int delLoveFall(String loginname){
        return ms.delLoveFall(loginname);
    }

    @RequestMapping("/insertCar")
    public int insertCar(@RequestBody MyCar car){
        return ms.insertCar(car);
    }

    @RequestMapping("/carFadeAll")
    public List<Map<String,Object>> carFadeAll(String loginname){
        return ms.carFadeAll(loginname);
    }

    @RequestMapping("/totalMoney")
    public String totalMoney(String uname){
        return ms.totalMoney(uname);
    }

    @RequestMapping("/delCar")
    public int delCar(int cid){
        return ms.delCar(cid);
    }

    @RequestMapping("/uptCarCommSum")
    public Map<String,Object> uptCarCommSum(@RequestBody MyCar car){
        return ms.uptCarCommSum(car);
    }

    @RequestMapping("/carFadeByID")
    public Map<String,Object> carFadeByID(int carid){
        return ms.carFadeByID(carid);
    }
}
