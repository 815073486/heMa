package com.hema.client;

import com.hemauser.Address;
import com.hemauser.HemaUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "user-provider")
public interface UserClient {
    @PostMapping("/phoneVerify")
    public boolean phoneVerify(@RequestParam String phone);
    @PostMapping("/addUser")
    public int addUser(@RequestBody HemaUser user);
    @PostMapping("/login")
    public boolean login(@RequestBody HemaUser user);
    @PostMapping("/insert_Address")
    public int insert_Address(@RequestBody Address add);
    @PostMapping("/addressFadeAll")
    public List<Address> addressFadeAll(@RequestParam String username);


}
