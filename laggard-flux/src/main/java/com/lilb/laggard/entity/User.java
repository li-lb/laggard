package com.lilb.laggard.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * 学生实体类
 *
 * @author lilinbi
 * @date 2022/04/22
 */
@Data
@Table("user")
public class User {

    @Id
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
