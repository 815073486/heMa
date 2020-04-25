package com.cssl.Service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.Service.ClassifyService;
import com.cssl.dao.ClassifyDao;
import com.cssl.entity.Classify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AutoConfigureAfter({ClassifyDao.class})
public class ClassifyServiceImpl extends ServiceImpl<ClassifyDao, Classify> implements ClassifyService {

    @Autowired
    private ClassifyDao cDao;

    /**
     * 查一级分类
     * @return
     */
    @Override
    public List<Classify> fallClassify() {

        return cDao.classify();
    }

    /**
     * 查二级分类
     * @param classify
     * @return
     */
    @Override
    public List<Classify> classifyId(Classify classify) {

        return cDao.classifyFather(classify);
    }


}
