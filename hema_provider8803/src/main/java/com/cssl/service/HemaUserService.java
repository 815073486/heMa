package com.cssl.service;

import com.cssl.entity.HemaUser;

import java.util.List;
import java.util.Map;

public interface HemaUserService {
    public List<Map<String,Object>> hemaUserFall();

    public int updateHemaUser(HemaUser hemaUser);

    public int deleteHemaUser(Integer userid);
}
