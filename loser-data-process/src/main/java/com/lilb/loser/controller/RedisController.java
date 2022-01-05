package com.lilb.loser.controller;

import com.lilb.loser.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lilinbi
 * @date 2021/12/27
 **/
@RestController
public class RedisController {
    

    @Autowired
    RedisService redisService;


    /**
     * 添加
     */
    @RequestMapping("/add")
    public void add(){
        
    }

}
