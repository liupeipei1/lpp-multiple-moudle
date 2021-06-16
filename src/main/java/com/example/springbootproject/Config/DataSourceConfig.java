package com.example.springbootproject.Config;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
/*
注入数据源
 */
@Configuration
// @ConfigurationProperties是springboot的注解，通过这个注解，项目可以获取到对应的配置属性，并返回数据源，
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druiDataSource(){
     return  new DruidDataSource();
    }

}
