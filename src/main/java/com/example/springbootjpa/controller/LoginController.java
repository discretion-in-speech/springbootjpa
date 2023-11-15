package com.example.springbootjpa.controller;

import com.example.springbootjpa.componts.R;
import com.example.springbootjpa.po.User;
import com.example.springbootjpa.service.UserService;
import com.example.springbootjpa.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("/login")
    public R login(@RequestBody User user){
        User user1 = userService.findByUsernameAndPWD(user);

        if(ObjectUtils.isEmpty(user1)){
            return R.FAILED("用户不存在");
        }

        //判断用户名相同
        if(user.getPassword().equals(user1.getPassword())){
            //脱敏
            user1.setPassword(null);
            //生成令牌
            String token = JwtUtil.getJwtToken(user1);
            //失效策略
//            redisTemplate.opsForValue().set(user.getUsername(),token,2, TimeUnit.HOURS);
            return R.SUCCESS(token);
        }else{
            return R.FAILED("密码错误");
        }

    }


}
