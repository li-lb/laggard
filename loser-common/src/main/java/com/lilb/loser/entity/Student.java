package com.lilb.loser.entity;

import cn.org.atool.fluent.mybatis.annotation.FluentMybatis;
import cn.org.atool.fluent.mybatis.base.IEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 学生
 *
 * @author li-lb
 * @date 2021/12/27
 */
@FluentMybatis
@Data
@NoArgsConstructor
public class Student implements IEntity {
    private Long id;
    private String name;
    private Integer age;
}