package com.cssl.service;

import com.cssl.entity.Hemauser;
import java.util.List;
import java.util.Map;

public interface HemaUserService {
    public List<Map<String,Object>> hemaUserFall();

    public int updateHemaUser(Hemauser hemaUser);

    public int deleteHemaUser(Integer userid);
}
