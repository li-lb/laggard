package com.lilb.loser.controller;

import com.lilb.loser.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 学生控制器
 *
 * @author li-lb
 * @date 2022/01/04
 */
@RestController
public class StudentController {

    @Autowired
    StudentMapper studentMapper;

    @GetMapping(value = "/payment/{id}")
    public String get(@PathVariable("id") Integer id){
        //studentMapper.l
        return null;
    }

}
