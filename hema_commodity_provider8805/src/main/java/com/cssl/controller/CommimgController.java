package com.cssl.controller;

import com.cssl.Service.CommimgService;
import com.cssl.entity.Commimg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommimgController {

    @Autowired
    private CommimgService cService;

    /**
     * 添加商品附图
     */
    @RequestMapping("/savCommimg")
    public int savCommimg(@RequestBody Commimg commimg){

        return cService.savCommimg(commimg);
    }

    /**
     * 删除商品附图
     * @return
     */
    @RequestMapping("/deleteCommimg")
    public int deleteCommimg(@RequestParam(name = "commid") Integer commid){
        return cService.deleteCommimg(commid);
    }
}
