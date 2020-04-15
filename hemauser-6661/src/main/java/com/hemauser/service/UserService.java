package com.hemauser.service;

import com.hemauser.HemaUser;
import com.hemauser.Verify;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author DELL
 * @Date 2020/4/10 19:14
 * @Version 1.0
 **/
public interface UserService {
    public boolean userVerify(String username);
    public boolean phoneVerify(String phone);
    public boolean addUser(HemaUser user);
    public boolean verify(Verify v);
    public boolean login(HemaUser user);
}
