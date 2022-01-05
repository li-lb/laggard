package com.lilb.loser.controller;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author lilinbi
 * @date 2021/12/27
 **/
@RestController
public class RedisController {
    

    @Autowired
    RedisService redisService;

    /**
     * 列表
     */
    @RequestMapping("/add")
    public void add(){
        
    }

}
