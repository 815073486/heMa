package com.commodity.service;

import com.hemacommodity.Commimg;
import com.hemacommodity.Discuss;
import com.hemacommodity.Parameter;

import java.util.List;
import java.util.Map;

public interface DetailsService {
    public Map<String,Object> commDetails(int cid);
    public List<Commimg> imgFall(int cid);
    public List<Parameter> parameterFall(int cid);
    public List<Discuss> discussFall(int cid);
    public List<Map<String,Object>> recommend(int cid);
    public Parameter parFadeById(int pid);
}
