package com.cssl.controller;

import com.cssl.Service.ParameterService;
import com.cssl.entity.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParameterController {

    @Autowired
    private ParameterService pService;   //参数服务

    /**
     * 添加商品参数
     * @return
     */
    @RequestMapping("/savparameter")
    public int savParameter(@RequestBody Parameter parameter){

        return pService.savParameter(parameter);
    }

    /**
     * 删除商品参数
     * @return
     */
    @RequestMapping("/delParameter")
    public int delParameter(@RequestParam(name = "commid") Integer commid){
        return pService.delParameter(commid);
    }
}
