package com.cssl.controller;

import com.cssl.Service.CommodityService;
import com.cssl.entity.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class CommodityController {

    @Autowired
    private CommodityService cService;   //商家服务


    /**
     * 添加商品
     * @param commodity
     * @return
     */
    @RequestMapping("/savCommodity")
    public Integer savCommodity(@RequestBody Commodity commodity){
        Integer comm=cService.savCommodity(commodity);
        Integer commid=commodity.getCommid();
        return commid;
    }



    /**
     * 查询单个商品
     * @param commid
     * @return
     */
    @RequestMapping("/commod")
    public Map<String,Object> commodity(@RequestParam(name = "commid") Integer commid){

        return cService.commodity(commid);
    }

    /**
     * 删除商品
     * @param commid
     * @return
     */
    @RequestMapping("/delCommodity")
    public int delCommodity(@RequestParam(name = "commid") Integer commid){
        return cService.delCommodity(commid);
    }

    /**
     * 修改商品
     * @param commodity
     * @return
     */
    @RequestMapping("/updateCommodity")
    public int updateCommodity(@RequestBody Commodity commodity){
        return cService.updateCommodity(commodity);
    }

    /**
     * 高级查询商品
     * @param map
     * @return
     */
    @RequestMapping("/advancedSelectCommodity")
    public List<Map<String, Object>> advancedSelectCommodity(@RequestParam Map<String,Object> map){
        System.out.println(map.get("page")+"****************"+map.get("pageindex"));
        return cService.advancedSelectCommodity(map);
    }

    /**
     * 查看商品总数
     * @return
     */
    @RequestMapping("/commodityCount")
    public int commodityConut(){
        return cService.commodityConut();
    }
}
