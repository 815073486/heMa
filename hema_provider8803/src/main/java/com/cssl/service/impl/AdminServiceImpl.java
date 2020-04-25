package com.cssl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.dao.AdmininfoDao;
import com.cssl.entity.Admininfo;
import com.cssl.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;

@Service
@AutoConfigureAfter({AdmininfoDao.class})
public class AdminServiceImpl extends ServiceImpl<AdmininfoDao, Admininfo> implements AdminService {

    @Autowired
    private AdmininfoDao aDao;

    /**
     * 登录方法
     * @param admin
     * @return
     */
    @Override
    public Admininfo login(Admininfo admin) {
        QueryWrapper<Admininfo> wrapper=new QueryWrapper<>();
        wrapper.eq("aname",admin.getAname());
        wrapper.eq("apassword",admin.getApassword());
        return aDao.selectOne(wrapper);
    }
}
