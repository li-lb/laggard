package com.lilb.loser.controller;


import com.lilb.loser.CommonResult;
import com.lilb.loser.dao.intf.StudentDao;
import com.lilb.loser.entity.StudentEntity;
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
    StudentDao studentDao;

    @GetMapping(value = "/selectById/{id}")
    public CommonResult<StudentEntity> selectById(@PathVariable("id") Integer id){
        StudentEntity studentEntity = studentDao.selectById(id);
        CommonResult<StudentEntity> studentEntityCommonResult = new CommonResult<>();
        studentEntityCommonResult.setData(studentEntity);
        studentEntityCommonResult.setCode(200);
        return studentEntityCommonResult;
    }

}
