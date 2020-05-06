package com.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.dao.UserstatusDao;
import com.cssl.entity.Userstatus;
import com.cssl.service.UserstatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AutoConfigureAfter({UserstatusDao.class})
public class UserstatusServiceImpl extends ServiceImpl<UserstatusDao, Userstatus> implements UserstatusService {

    @Autowired
    private UserstatusDao uDao;

    /**
     * 查询所有用户状态
     * @return
     */
    @Override
    public List<Userstatus> userstatusFall() {
        return uDao.selectByMap(null);
    }
}
