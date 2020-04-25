package com.cssl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cssl.entity.HemaUser;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;

@Mapper
public interface HemaUserDao extends BaseMapper<HemaUser> {

    public List<Map<String,Object>> hemaUserFall();

}
