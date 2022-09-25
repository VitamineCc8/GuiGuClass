package com.wei.ggkt.vod.controller;

import com.wei.ggkt.result.Result;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author VitamineG
 * @DateTime 2022/9/8 21:11
 */
@RestController
//@CrossOrigin
@RequestMapping("/admin/vod/user")
public class LoginController {

    /**
     * 登陆
     */
    //login
    @PostMapping("login")
    public Result login() {
        //{code: 20000, data: {token: "admin-token"}}
        HashMap<String, Object> map = new HashMap<>();
        map.put("token", "admin-token");
        return Result.ok(map);
    }


    /**
     * 获取信息
     */
    //info?token=admin-token
    @GetMapping("info")
    public Result info() {
        Map<String, Object> map = new HashMap<>();
        map.put("roles","[admin]");
        map.put("name","admin");
        map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("introduction","I am a super administrator");
        return Result.ok(map);
    }


}
