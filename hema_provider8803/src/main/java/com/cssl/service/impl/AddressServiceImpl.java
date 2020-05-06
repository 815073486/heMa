package com.cssl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.dao.AddressDao;
import com.cssl.entity.Address;
import com.cssl.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;

@Service
@AutoConfigureAfter({AddressDao.class})
public class AddressServiceImpl extends ServiceImpl<AddressDao, Address> implements AddressService {

    @Autowired
    private AddressDao aDao;

    /**
     * 修改订单收货地址
     * @param address
     * @return
     */
    @Override
    public int updateAddress(Address address) {
        QueryWrapper<Address> wrapper = new QueryWrapper<>();
        wrapper.eq("addressid",address.getAdderssid());
        address.setAdderssid(null);
        address.setLoginname(null);
        return aDao.update(address,wrapper);
    }
}
