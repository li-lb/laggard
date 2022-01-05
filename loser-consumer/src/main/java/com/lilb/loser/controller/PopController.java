package com.lilb.loser.controller;

import com.lilb.loser.CommonResult;
import com.lilb.loser.service.PopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lilinbi
 * @date 2021/12/27
 **/
@RestController
public class PopController {


    @Autowired
    PopService popService;

    /**
     * 列表
     */
    @RequestMapping("/consumer/selectById/{id}")
    public CommonResult selectById(@PathVariable("id") Integer id){
        CommonResult commonResult = popService.selectById(id);
        return commonResult;
    }
}
