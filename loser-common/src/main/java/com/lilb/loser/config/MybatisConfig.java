package com.lilb.loser.config;

import cn.org.atool.fluent.mybatis.spring.MapperFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class MybatisConfig {

    @Bean
    public MapperFactory mapperFactory() {
        return new MapperFactory();
    }
}