package com.commodity.service.Impl;

import com.commodity.dao.ClassifyDao;
import com.commodity.service.ClassifyService;
import com.hemacommodity.Classify;
import com.hemacommodity.Commodity;
import com.hemacommodity.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ClassifyServiceImpl
 * @Description TODO
 * @Author DELL
 * @Date 2020/4/15 16:30
 * @Version 1.0
 **/
@Service
public class ClassifyServiceImpl implements ClassifyService {
    @Autowired
    private ClassifyDao cd;
    @Override
    public List<Classify> mumeFall() {
        return cd.mumeFall();
    }

    @Override
    public List<Map<String, Object>> indexFall() {
        return cd.indexFall();
    }

    @Override
    public List<Map<String, Object>> salesFall() {
        return cd.salesFall();
    }

    @Override
    public List<Map<String, Object>> comm_Fade_ByName(String c_name) {
        return cd.comm_Fade_ByName(c_name);
    }

    @Override
    public List<Map<String, Object>> comm_by_classifyid(int classifyid) {
        return cd.comm_by_classifyid(classifyid);
    }

    @Override
    public int upt_Stocknum(Parameter parameter) {
        return cd.upt_Stocknum(parameter);
    }

    @Override
    public int upt_sales(Commodity commodity) {
        return cd.upt_sales(commodity);
    }
}
