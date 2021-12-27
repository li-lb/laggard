package com.lilb.loser.controller;

import com.lilb.loser.entity.Student;
import com.lilb.loser.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lilinbi
 * @date 2021/12/27
 **/
@RestController
public class PopController {

    @Autowired
    private StudentMapper studentMapper;
    @RequestMapping("insert")
    public void insert(){
        Student student = new Student();
        student.setName("dl");
        student.setAge(25);
        studentMapper.insert(student);
    }
}
