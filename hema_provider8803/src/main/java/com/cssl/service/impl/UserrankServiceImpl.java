package com.cssl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.dao.UserrankDao;
import com.cssl.entity.Userrank;
import com.cssl.service.UserrankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AutoConfigureAfter({UserrankDao.class})
public class UserrankServiceImpl extends ServiceImpl<UserrankDao, Userrank> implements UserrankService {

    @Autowired
    private UserrankDao uDao;

    @Override
    public List<Userrank> UserrankFall() {
        return uDao.selectByMap(null);
    }
}
