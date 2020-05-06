package com.cssl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.dao.HemaUserDao;
import com.cssl.entity.Hemauser;
import com.cssl.service.HemaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AutoConfigureAfter({HemaUserDao.class})
public class HemaUserServiceImpl extends ServiceImpl<HemaUserDao, Hemauser> implements HemaUserService {

    @Autowired
    private HemaUserDao hDao;

    @Override
    public List<Map<String, Object>> hemaUserFall() {
        return hDao.hemaUserFall();
    }

    @Override
    public int updateHemaUser(Hemauser hemaUser) {
        QueryWrapper<Hemauser> wrapper=new QueryWrapper<>();
        wrapper.eq("userid",hemaUser.getUserid());
        hemaUser.setUserid(null);
        return hDao.update(hemaUser,wrapper);
    }

    @Override
    public int deleteHemaUser(Integer userid) {
        QueryWrapper<Hemauser> wrapper=new QueryWrapper<>();
        wrapper.eq("userid",userid);
        return hDao.delete(wrapper);
    }
}
