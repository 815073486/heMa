package com.cssl.controller;

import com.cssl.Service.ClassifyService;
import com.cssl.entity.Classify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClassifyController {

    @Autowired
    private ClassifyService cService;

    /**
     * 查一级类型
     */
    @RequestMapping("/classify")
    public List<Classify> fallClassify(){
        return cService.fallClassify();
    }

    /**
     * 查二级类型
     * @param fatherid
     * @return
     */
    @RequestMapping("/classifyId")
    public List<Classify> classifyId(@RequestBody Classify fatherid){
        return cService.classifyId(fatherid);
    }



}
