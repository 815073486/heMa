package com.commodity.Controller;

import com.commodity.service.DetailsService;
import com.commodity.service.Impl.DetailsServiceImpl;
import com.hemacommodity.Commimg;
import com.hemacommodity.Discuss;
import com.hemacommodity.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @ClassName DetailsController
 * @Description TODO
 * @Author DELL
 * @Date 2020/4/18 18:53
 * @Version 1.0
 **/
@RestController
public class DetailsController {
    @Autowired
    private DetailsService ds;

    @RequestMapping("/commDetails")
    public Map<String, Object> commDetails(int cid){
        return ds.commDetails(cid);
    }

    @RequestMapping("/imgFall")
    public List<Commimg> imgFall(int cid){
        return ds.imgFall(cid);
    }

    @RequestMapping("/parameterFall")
    public List<Parameter> parameterFall(int cid){
        return ds.parameterFall(cid);
    }

    @RequestMapping("/discussFall")
    public List<Discuss> discussFall(int cid) {
        return ds.discussFall(cid);
    }

    @RequestMapping("/recommend")
    public List<Map<String, Object>> recommend(int cid) {
        return ds.recommend(cid);
    }

    @RequestMapping("/parFadeById")
    public Parameter parFadeById(int pid) {
        return ds.parFadeById(pid);
    }

}
