package com.cssl.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.Service.ParameterService;
import com.cssl.dao.ParameterDao;
import com.cssl.entity.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;

@Service
@AutoConfigureAfter({ParameterDao.class})
public class ParameterServiceImpl extends ServiceImpl<ParameterDao, Parameter> implements ParameterService {

    @Autowired
    private ParameterDao pDao;

    /**
     * 添加商品参数
     * @return
     */
    @Override
    public int savParameter(Parameter parameter) {

        return pDao.insert(parameter);
    }

    /**
     * 删除商品参数
     * @return
     */
    @Override
    public int delParameter(Integer commid) {
        QueryWrapper<Parameter> wrapper=new QueryWrapper<>();
        wrapper.eq("commid",commid);
        return pDao.delete(wrapper);
    }

}
