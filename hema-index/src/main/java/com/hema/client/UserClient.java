package com.hema.client;

import com.hemauser.HemaUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-provider")
public interface UserClient {
    @PostMapping("/userVerify")
    public boolean userVerify(@RequestParam String username);
    @PostMapping("/phoneVerify")
    public boolean phoneVerify(@RequestParam String phone);
    @PostMapping("/phone")
    public void phoneyzm(@RequestParam String phone);
    @PostMapping("/addUser")
    public boolean addUser(@RequestBody HemaUser user);
    @PostMapping("/login")
    public boolean login(@RequestBody HemaUser user);


}
