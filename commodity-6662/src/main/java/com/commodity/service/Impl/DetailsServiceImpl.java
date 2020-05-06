package com.commodity.service.Impl;

import com.commodity.dao.DetailsDao;
import com.commodity.service.DetailsService;
import com.hemacommodity.Commimg;
import com.hemacommodity.Discuss;
import com.hemacommodity.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName DetailsServiceImpl
 * @Description TODO
 * @Author DELL
 * @Date 2020/4/18 18:51
 * @Version 1.0
 **/
@Service
public class DetailsServiceImpl implements DetailsService {
    @Autowired
    private DetailsDao ds;
    @Override
    public Map<String, Object> commDetails(int cid) {

        return ds.commDetails(cid);
    }

    @Override
    public List<Commimg> imgFall(int cid) {
        return ds.imgFall(cid);
    }

    @Override
    public List<Parameter> parameterFall(int cid) {
        return ds.parameterFall(cid);
    }

    @Override
    public List<Discuss> discussFall(int cid) {
        return ds.discussFall(cid);
    }

    @Override
    public List<Map<String, Object>> recommend(int cid) {
        return ds.recommend(cid);
    }

    @Override
    public Parameter parFadeById(int pid) {
        return ds.parFadeById(pid);
    }
}
