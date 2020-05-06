package com.commodity.Controller;

import com.commodity.service.Impl.ClassifyServiceImpl;
import com.hemacommodity.Classify;
import com.hemacommodity.Commodity;
import com.hemacommodity.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassName CommClntroller
 * @Description TODO
 * @Author DELL
 * @Date 2020/4/15 16:32
 * @Version 1.0
 **/
@RestController
public class CommClntroller {
    @Autowired
    private ClassifyServiceImpl cs;

    @PostMapping("/mumeFall")
    public List<Classify> mumeFall(){
        return cs.mumeFall();
    }

    @PostMapping("/indexFall")
    public List<Map<String,Object>> indexFall(){
        return cs.indexFall();
    }

    @PostMapping("/salesFall")
    public List<Map<String,Object>> salesFall(){
        return cs.salesFall();
    }

    @RequestMapping("/comm_Fade_ByName")
    public List<Map<String,Object>> comm_Fade_ByName(String c_name){
        return cs.comm_Fade_ByName(c_name);
    }

    @RequestMapping("/comm_by_classifyid")
    public List<Map<String,Object>> comm_by_classifyid(int classifyid){
        return cs.comm_by_classifyid(classifyid);
    }

    @RequestMapping("/upt_Stocknum")
    public int upt_Stocknum(@RequestBody Parameter parameter){
        return cs.upt_Stocknum(parameter);
    }

    @RequestMapping("/upt_sales")
    public int upt_sales(@RequestBody Commodity commodity){
        return cs.upt_sales(commodity);
    }


}
