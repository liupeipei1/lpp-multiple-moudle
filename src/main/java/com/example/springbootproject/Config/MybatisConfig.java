package com.example.springbootproject.Config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/*
 1、数据源
 2、自定义xml路径
 */
@Configuration
public class MybatisConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        //注意：classspath :只会到你classpathc查找路径
        //classPath* 不仅是查询class路径  还会查找jar中得class路径  这样加载很慢
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classPath*:/mapper/*/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

}

