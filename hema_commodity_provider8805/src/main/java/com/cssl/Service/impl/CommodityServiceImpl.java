package com.cssl.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.Service.CommodityService;
import com.cssl.dao.CommodityDao;
import com.cssl.entity.Commodity;
import org.apache.ibatis.annotations.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AutoConfigureAfter({CommodityDao.class})
public class CommodityServiceImpl extends ServiceImpl<CommodityDao, Commodity> implements CommodityService {

    @Autowired
    private CommodityDao cDao;

    /**
     * 添加商品
     * @return
     */
    @Override
    public int savCommodity(Commodity commodity) {

        return cDao.insert(commodity);
    }



    /**
     * 查询单个商品
     * @return
     */
    @Override
    public Map<String, Object> commodity(Integer commid) {
        Map<String,Object> map=new HashMap<>();
        map.put("commid",commid);
        return cDao.commodity(map);
    }


    /**
     * 删除商品
     * @return
     */
    @Override
    public int delCommodity(Integer commid) {
        QueryWrapper<Commodity> wrapper=new QueryWrapper<>();
        wrapper.eq("commid",commid);
        return cDao.delete(wrapper);
    }

    /**
     * 修改商品
     * @param commodity
     * @return
     */
    @Override
    public int updateCommodity(Commodity commodity) {
        QueryWrapper<Commodity> wrapper=new QueryWrapper<>();
        wrapper.eq("commid",commodity.getCommid());
        commodity.setCommid(null);
        return cDao.update(commodity,wrapper);
    }

    /**
     * 高级查询商品
     * @param map
     * @return
     */
    @Override
    public List<Map<String, Object>> advancedSelectCommodity(Map<String,Object> map) {

        return cDao.advancedSelectCommodity(map);
    }

    @Override
    public int commodityConut() {
        return cDao.commodityConut();
    }


}
