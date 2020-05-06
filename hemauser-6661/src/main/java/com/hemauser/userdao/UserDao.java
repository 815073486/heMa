package com.hemauser.userdao;

import com.hemauser.Address;
import com.hemauser.HemaUser;
import com.hemauser.Verify;

import java.util.List;

public interface UserDao {
    public int phoneVerify(String phone);
    public int addUser(HemaUser user);
    public int login(HemaUser user);
    public int insert_Address(Address add);
    public List<Address> addressFadeAll(String username);

}
