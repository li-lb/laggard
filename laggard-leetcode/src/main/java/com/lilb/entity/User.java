package com.lilb.entity;

import lombok.Data;

/**
 * 学生实体类
 *
 * @author lilinbi
 * @date 2022/04/22
 */
@Data
public class User {

    private int id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private int age;

    /**
     * 地址
     */
    private String email;

}
