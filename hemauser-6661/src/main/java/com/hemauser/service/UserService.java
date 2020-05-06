package com.hemauser.service;

import com.hemauser.Address;
import com.hemauser.HemaUser;
import com.hemauser.Verify;

import java.util.List;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author DELL
 * @Date 2020/4/10 19:14
 * @Version 1.0
 **/
public interface UserService {
    public boolean phoneVerify(String phone);
    public int addUser(HemaUser user);
    public boolean login(HemaUser user);
    public int insert_Address(Address add);
    public List<Address> addressFadeAll(String username);
}
