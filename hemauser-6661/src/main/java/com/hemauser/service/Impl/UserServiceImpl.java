package com.hemauser.service.Impl;

import com.hemauser.HemaUser;
import com.hemauser.Verify;
import com.hemauser.service.UserService;
import com.hemauser.userdao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author DELL
 * @Date 2020/4/10 19:15
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao ud;
    //用于验证用户名是否存在方法
    @Override
    public boolean userVerify(String username) {
        if(ud.userVerify(username)>0){
            return false;
        }
        return true;
    }

    @Override
    public boolean phoneVerify(String phone) {
        if(ud.phoneVerify(phone)>0){
            return false;
        }
        return true;
    }

    @Override
    public boolean addUser(HemaUser user) {
        if(ud.addUser(user)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean verify(Verify v) {
        if(ud.verify(v)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean login(HemaUser user) {
        if(ud.login(user)>0){
            return true;
        }
        return false;
    }
}
