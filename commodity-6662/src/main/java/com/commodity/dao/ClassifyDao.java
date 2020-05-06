package com.commodity.dao;

import com.hemacommodity.Classify;
import com.hemacommodity.Commodity;
import com.hemacommodity.Parameter;

import java.util.List;
import java.util.Map;

public interface ClassifyDao {
    public List<Classify> mumeFall();
    public List<Map<String,Object>> indexFall();
    public List<Map<String,Object>> salesFall();
    public List<Map<String,Object>> comm_Fade_ByName(String c_name);
    public List<Map<String,Object>> comm_by_classifyid(int classifyid);
    public int upt_Stocknum(Parameter parameter);
    public int upt_sales(Commodity commodity);
}
