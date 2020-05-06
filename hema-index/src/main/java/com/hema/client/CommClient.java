package com.hema.client;

import com.hemacommodity.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @ClassName CommClient
 * @Description TODO
 * @Author DELL
 * @Date 2020/4/15 16:36
 * @Version 1.0
 **/
@FeignClient(name="comm-provider")
public interface CommClient {
    @PostMapping("/mumeFall")   //前台展示
    public List<Classify> mumeFall();

    @PostMapping("/indexFall")  //上架时间商品排序
    public List<Map<String,Object>> indexFall();

    @PostMapping("/salesFall")  //销量排序
    public List<Map<String,Object>> salesFall();

    @RequestMapping("/comm_Fade_ByName")
    public List<Map<String,Object>> comm_Fade_ByName(@RequestParam String c_name);//搜索查询商品

    @RequestMapping("/comm_by_classifyid")
    public List<Map<String,Object>> comm_by_classifyid(@RequestParam int classifyid);//根据分类ID查询

    @RequestMapping("/upt_Stocknum")
    public int upt_Stocknum(@RequestBody Parameter parameter);//修改商品库存

    @RequestMapping("/upt_sales")
    public int upt_sales(@RequestBody Commodity commodity);//增加商品销量

    @RequestMapping("/commDetails")  //商品详情
    public Map<String, Object> Details(@RequestParam int cid);

    @RequestMapping("/imgFall")  //商品图片查询
    public List<Commimg> imgFall(@RequestParam int cid);

    @RequestMapping("/parameterFall")  //全部商品参数
    public List<Parameter> parameterFall(@RequestParam int cid);

    @RequestMapping("/discussFall")  //查看商品评价
    public List<Discuss> discussFall(@RequestParam int cid);

    @RequestMapping("/recommend")//商品详情页面推荐商品展示
    public List<Map<String, Object>> recommend(@RequestParam int cid);

    @RequestMapping("/parFadeById")//根据参数id查看商品具体的参数
    public Parameter parFadeById(@RequestParam int pid);

    @RequestMapping("/myLove") //添加我的喜欢的商品
    public int myLove(@RequestBody MyLove love);

    @RequestMapping("/loveFall") //查看我所有喜欢的商品
    public List<Map<String,Object>> loveFall(@RequestParam String loginname);

    @RequestMapping("/delLoveById") //删除我喜欢的商品
    public int delLoveById(@RequestParam int loveid);

    @RequestMapping("/delLoveFall") //删除我喜欢的所有商品
    public int delLoveFall(@RequestParam String loginname);

    @RequestMapping("/insertCar") //新增购物车商品
    public int insertCar(@RequestBody MyCar car);

    @RequestMapping("/carFadeAll")
    public List<Map<String,Object>> carFadeAll(@RequestParam String loginname);

    @RequestMapping("/totalMoney")
    public String totalMoney(@RequestParam String uname);

    @RequestMapping("/delCar")
    public int delCar(@RequestParam int cid);

    @RequestMapping("/uptCarCommSum")
    public Map<String,Object> uptCarCommSum(@RequestBody MyCar car);

    @RequestMapping("/carFadeByID")
    public Map<String,Object> carFadeByID(@RequestParam int carid);


}
