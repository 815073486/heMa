package com.cssl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cssl.entity.Commodity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
public interface CommodityDao extends BaseMapper<Commodity> {
    public List<Map<String,Object>> selectCommodity();

    public Map<String,Object> commodity(Map<String,Object> map);

    public List<Map<String,Object>> advancedSelectCommodity(Map<String,Object> map);
}
