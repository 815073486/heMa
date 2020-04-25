package com.cssl.client;

import com.cssl.entity.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient("hema-provider-commodity")
public interface ClassifyClient {

    /**
     * 一级分类
     * @return
     */
    @RequestMapping("/classify")
    public List<Classify> fallClassify();

    /**
     * 二级分类
     * @param fatherid
     * @return
     */
    @RequestMapping("/classifyId")
    public List<Classify> classifyId(Classify fatherid);

    /**
     * 添加商家
     * @param merchant
     * @return
     */
    @RequestMapping("/merchant")
    public int savMerchant(Merchant merchant);

    /**
     * 查询所有商家
     * @return
     */
    @RequestMapping("/merchantfall")
    public List<Merchant> fallMerchant();



    /**
     * 查询所有商品
     */
    @RequestMapping("/commodity")
    public List<Map<String,Object>> selectCommodity();

    /**
     * 查询单个商品
     * @param commid
     * @return
     */
    @RequestMapping("/commod")
    public Map<String,Object> commodity(@RequestParam(name = "commid") Integer commid);

    /**
     * 删除商家
     * @param merchantid
     * @return
     */
    @RequestMapping("/merchantDel")
    public int merchantDel(@RequestParam(name = "merchantid") Integer merchantid);

    /**
     * 添加商品
     * @param commodity
     * @return
     */
    @RequestMapping("/savCommodity")
    public int savCommodity(@RequestBody Commodity commodity);

    /**
     * 商品参数
     * @param parameter
     * @return
     */
    @RequestMapping("/savparameter")
    public Integer savParameter(@RequestBody Parameter parameter);

    /**
     * 添加商品附图
     * @param commimg
     * @return
     */
    @RequestMapping("/savCommimg")
    public int savCommimg(@RequestBody Commimg commimg);

    /**
     * 删除商品参数
     * @param commid
     * @return
     */
    @RequestMapping("/delParameter")
    public int delParameter(@RequestParam(name = "commid") Integer commid);

    /**
     * 删除商品附图
     * @param commid
     * @return
     */
    @RequestMapping("/deleteCommimg")
    public int deleteCommimg(@RequestParam(name = "commid") Integer commid);

    /**
     * 删除商品
     * @param commid
     * @return
     */
    @RequestMapping("/delCommodity")
    public int delCommodity(@RequestParam(name = "commid") Integer commid);

    /**
     * 修改商品
     * @param commodity
     * @return
     */
    @RequestMapping("/updateCommodity")
    public int updateCommodity(@RequestBody Commodity commodity);

    /**
     * 修改商家
     * @param merchant
     * @return
     */
    @RequestMapping("/updateMerchant")
    public int updateMerchant(Merchant merchant);

    @RequestMapping("/advancedSelectCommodity")
    public List<Map<String, Object>> advancedSelectCommodity(@RequestParam Map<String,Object> map);


}
