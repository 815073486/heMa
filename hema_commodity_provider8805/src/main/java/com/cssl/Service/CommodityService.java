package com.cssl.Service;

import com.cssl.entity.Commodity;

import java.util.List;
import java.util.Map;

public interface CommodityService {

    public int savCommodity(Commodity commodity);


    public Map<String,Object> commodity(Integer commid);

    public int delCommodity(Integer commid);

    public int updateCommodity(Commodity commodity);

    public List<Map<String,Object>> advancedSelectCommodity(Map<String,Object> map);

    public int commodityConut();
}
