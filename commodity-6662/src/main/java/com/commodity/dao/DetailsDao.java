package com.commodity.dao;

import com.hemacommodity.Commimg;
import com.hemacommodity.Discuss;
import com.hemacommodity.Parameter;

import java.util.List;
import java.util.Map;

public interface DetailsDao {
        public Map<String,Object> commDetails(int cid);//展示商品详情
        public List<Commimg> imgFall(int cid);//图片展示
        public List<Parameter> parameterFall(int cid);//查看所有参数
        public List<Discuss> discussFall(int cid);//商品评价展示
        public List<Map<String,Object>> recommend(int cid);//推荐类似商品
        public Parameter parFadeById(int pid);
}
