package com.cssl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cssl.entity.Address;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AddressDao extends BaseMapper<Address> {
}
