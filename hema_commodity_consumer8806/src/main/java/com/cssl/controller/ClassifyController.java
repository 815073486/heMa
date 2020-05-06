package com.cssl.controller;

import com.alibaba.fastjson.JSONObject;
import com.cssl.client.ClassifyClient;
import com.cssl.entity.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ClassifyController {

    @Autowired
    private ClassifyClient client;

    /**
     * 一级分类
     * @return
     */
    @RequestMapping("/consumer/classifyfall")
    public List<Classify> fallClassify(){
        return client.fallClassify();
    }

    /**
     * 二级分类
     * @return
     */
    @RequestMapping("/consumer/classifyId")
    public List<Classify> classifyById(Classify fatherid){
        return client.classifyId(fatherid);
    }



    /**
     * 查询所有商家下拉框
     * @return
     */
    @RequestMapping("/consumer/merchantfall")
    public List<Merchant> fallMerchant(){

        return client.fallMerchant();
    }

    @RequestMapping("/manager/uploadimg")
    public Map<String, Object> uploadPicture(@RequestParam("file") MultipartFile file, HttpServletRequest servletRequest)
            throws IOException {
        //如果文件内容不为空，则写入上传路径
        Map<String,Object> map=new HashMap<>();
        JSONObject resUrl = new JSONObject();
        //上传文件路径
        String path = "F:/heMa/hema_commodity_consumer8806/target/classes/static/picture";
        String path2="F:/heMa/hema-index/target/classes/static/picture";
        //上传文件名
        String name = file.getOriginalFilename();//上传文件的真实名称
        String suffixName = name.substring(name.lastIndexOf("."));//获取后缀名
        String indexName = name.substring(0,name.lastIndexOf("."));//获取文件名
        File filepath = new File(path, name);
        File tempFile = new File(path + File.separator + name);
        File tempFile2 = new File(path2 + File.separator + name);
        file.transferTo(tempFile2);
        resUrl.put("src", file.getOriginalFilename());
        map.put("code", 0);
        map.put("msg", "");
        map.put("data", resUrl);
        return map;
    }

    /**
     * 添加商品 和  商品参数
     */
    @RequestMapping("/consumer/savCommodity")
    public int savCommodity(@RequestParam Map<String,String> reqMap){
        int s=0;
        //创建商品
        Commodity commodity=new Commodity();
        if(reqMap.get("fatherid")==null){
            commodity.setClassifyid(Integer.parseInt(reqMap.get("classifyid")));
        }else{
            commodity.setClassifyid(Integer.parseInt(reqMap.get("fatherid")));
        }
        commodity.setCommname(reqMap.get("commname"));
        commodity.setCommimg("picture/"+reqMap.get("commimg"));
        commodity.setMerchantid(Integer.parseInt(reqMap.get("merchantid")));
        if("on".equals(reqMap.get("rush"))){
            commodity.setRush(1);
        }else{
            commodity.setRush(0);
        }
        commodity.setPresentation(reqMap.get("presentation"));
        //商品参数对象
        Parameter parameter=new Parameter();
        parameter.setParameter(reqMap.get("parameter"));
        parameter.setPrice(Double.parseDouble(reqMap.get("price")));
        parameter.setStocknum(Integer.parseInt(reqMap.get("stocknum")));
        Integer commid1=client.savCommodity(commodity);
        if(commid1!=null){
            if(commid1>0) {
                //添加商品id
                parameter.setCommid(commid1);
                if (client.savParameter(parameter) > 0) {
                    //商品附图对象
                    String img2=reqMap.get("img");
                    String [] images=img2.split(",");
                    for (int i=0;i<images.length;i++){
                        Commimg commimg=new Commimg();
                        commimg.setCommid(commid1);
                        commimg.setImg("commimg/"+images[i]);
                        System.out.println("*********"+i);
                        if(client.savCommimg(commimg)>0){
                            s=200;
                        }
                    }
                }
            }
        }
        return s;
    }

    /**
     * 删除商品，商品参数，商品附图
     */
    @RequestMapping("/consumer/delCommodity")
    public int delCommodity(@RequestParam(name = "commid") Integer commid){
        if(client.deleteCommimg(commid)>0&&client.delParameter(commid)>0&&client.delCommodity(commid)>0)
            return 1;
        return 0;
    }


    /**
     * 查询单个商品
     * @param commid
     * @return
     */
    @RequestMapping("/consumer/commod")
    public Map<String,Object> commodity(@RequestParam(name = "commid") Integer commid){
        return client.commodity(commid);
    }

    /**
     * 修改商品
     */
    @RequestMapping("/consumer/updateCommodity")
    public int updateCommodity(@RequestParam Map<String,String> map){
        Commodity commodity=new Commodity();
        commodity.setCommname(map.get("commname"));
        commodity.setCommid(Integer.parseInt(map.get("commid")));
        commodity.setPresentation(map.get("presentation"));
        commodity.setCommimg("picture/"+map.get("commimg"));
        if(map.get("fatherid")==null){
            commodity.setClassifyid(Integer.parseInt(map.get("classifyid")));
        }else{
            commodity.setClassifyid(Integer.parseInt(map.get("fatherid")));
        }
        commodity.setMerchantid(Integer.getInteger(map.get("merchant")));
        if("on".equals(map.get("rush"))){
            commodity.setRush(1);
        }else{
            commodity.setRush(0);
        }
        return client.updateCommodity(commodity);
    }

    /**
     *  查询商家列表
     */
    @RequestMapping("/consumer/merchant2")
    public Map<String,Object> fallMerchant2(){
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("count",client.fallMerchant().size());
        map.put("data",client.fallMerchant());
        return map;
    }

    /**
     * 删除商家
     * @param merchantid
     * @return
     */
    @RequestMapping("/consumer/merchantDel")
    public int merchantDel(@RequestParam(name = "merchantid") Integer merchantid){
        return client.merchantDel(merchantid);
    }

    /**
     * 添加商家
     * @return
     */
    @RequestMapping("/consumer/merchant")
    public int savMerchant(@RequestBody Merchant merchant){
        return client.savMerchant(merchant);
    }

    /**
     * 修改商家
     * @param merchant
     * @return
     */
    @RequestMapping("/consumer/updateMerchant")
    public int updateMerchant(@RequestBody Merchant merchant,@RequestParam(name = "merchantid") Integer merchantid){

        return client.updateMerchant(merchant);
    }

    /**
     * 高级查询商品
     * @param map
     * @return
     */
    @RequestMapping("/consumer/advancedSelectCommodity")
    public Map<String,Object> advancedSelectCommodity(@RequestParam Map<String,Object> map,Integer page,Integer pageindex){
        if(map.get("commtime")!=""&&map.get("commtime")!=null){
            map.put("commtime",map.get("commtime")+"%");
        }
        if(map.get("commid")==null||map.get("commid")==""){
            map.put("commid",0);
        }

        if(page==null){
            page=1;
        }
        if(pageindex==null){
            pageindex=10;
        }
        map.put("page",(page-1)*pageindex);
        map.put("pageindex",pageindex);
        PageHelper.startPage(Integer.parseInt(map.get("page").toString()),Integer.parseInt(map.get("pageindex").toString()));
        List<Map<String,Object>> list=client.advancedSelectCommodity(map);
        Map<String,Object> map1=new HashMap<>();
        map1.put("code",0);
        map1.put("count",client.commodityConut());
        map1.put("data",list);
        return map1;
    }

}
