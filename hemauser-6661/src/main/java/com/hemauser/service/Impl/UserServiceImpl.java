package com.hemauser.service.Impl;

import com.hemauser.Address;
import com.hemauser.HemaUser;
import com.hemauser.Verify;
import com.hemauser.service.UserService;
import com.hemauser.userdao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public boolean phoneVerify(String phone) {
        if(ud.phoneVerify(phone)>0){
            return false;
        }
        return true;
    }

    @Override
    public int addUser(HemaUser user) {

        return ud.addUser(user);
    }

    @Override
    public boolean login(HemaUser user) {
        if(ud.login(user)>0){
            return true;
        }
        return false;
    }

    @Override
    public int insert_Address(Address add) {
        return ud.insert_Address(add);
    }

    @Override
    public List<Address> addressFadeAll(String username) {
        return ud.addressFadeAll(username);
    }
}
