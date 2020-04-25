package com.cssl.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.Service.CommimgService;
import com.cssl.dao.CommimgDao;
import com.cssl.entity.Commimg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;

@Service
@AutoConfigureAfter({CommimgDao.class})
public class CommimgServiceImpl extends ServiceImpl<CommimgDao, Commimg> implements CommimgService {

    @Autowired
    private CommimgDao cDao;

    /**
     * 添加商品附图
     * @return
     */
    @Override
    public int savCommimg(Commimg commimg) {

        return cDao.insert(commimg);
    }

    /**
     * 删除商品附图
     * @return
     */
    @Override
    public int deleteCommimg(Integer commid) {
        QueryWrapper<Commimg> wrapper=new QueryWrapper<>();
        wrapper.eq("commid",commid);
        return cDao.delete(wrapper);
    }
}
