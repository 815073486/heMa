package com.cssl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cssl.entity.Classify;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 商品分类
 */
@Mapper
public interface ClassifyDao extends BaseMapper<Classify> {
    public List<Classify> classify();

    public List<Classify> classifyFather(Classify classify);
}
