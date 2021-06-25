package com.example.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
注入数据源
 */
@Configuration
// @ConfigurationProperties是springboot的注解，通过这个注解，项目可以获取到对应的配置属性，并返回数据源，
@MapperScan(basePackages = MasterDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "masterSqlSessionFactory")
public class MasterDataSourceConfig {

    static final String PACKAGE = "com.example.Dao.master"; //dao的地址
    static final String MAPPER_LOCATION = "classpath:mapper/master/*.xml"; //mybatis。xml地址


    @Value("${master.datasource.url}")
    private String url;

    @Value("${master.datasource.username}")
    private String user;

    @Value("${master.datasource.password}")
    private String password;

    @Value("${master.datasource.driverClassName}")
    private String driverClass;

    @Bean(name = "masterDataSource") //方法1：
    @Primary
    public DataSource masterDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }



  /* 方法1等价于该方法：
   @Bean(name = "masterDataSource")
    @ConfigurationProperties(prefix = "master.datasource")
    @Primary
    public DataSource masterDataSource() {
        return DataSourceBuilder.create().build();
    }
*/

    @Bean(name = "masterTransactionManager")
    @Primary
    public DataSourceTransactionManager masterTransactionManager() {
        return new DataSourceTransactionManager(masterDataSource());
    }


    @Bean(name = "masterSqlSessionFactory")
    @Primary
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSource") DataSource masterDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(masterDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(MasterDataSourceConfig.MAPPER_LOCATION));  //设置XML地址
        return sessionFactory.getObject();
    }

    /**
     * 配置Druid监控
     * web：http://localhost:8082/druid
     * @return ServletRegistrationBean
     * 原文链接：https://blog.csdn.net/qq_27634797/article/details/100560118
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        Map<String, String> map = new HashMap<>();
        map.put(StatViewServlet.PARAM_NAME_USERNAME, "lpp");  //访问的用户名密码
        map.put(StatViewServlet.PARAM_NAME_PASSWORD, "123456");
        //允许访问的ip，默认是所有ip
        map.put(StatViewServlet.PARAM_NAME_ALLOW, "");
        //禁止访问的ip
        // map.put(StatViewServlet.PARAM_NAME_DENY, "192.168.1.1");
        bean.setInitParameters(map);
        return bean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean<WebStatFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new WebStatFilter());
        Map<String, String> map = new HashMap<>();
        //移除这些监听
        map.put(WebStatFilter.PARAM_NAME_EXCLUSIONS, "*.js,*.css,/druid/*,*.gif,*.jpg,*.png");
        bean.setInitParameters(map);
        //拦截所有请求，全部都要走druid监听
        bean.setUrlPatterns(Collections.singletonList("/*"));
        return bean;
        //原文链接：https://blog.csdn.net/qq_27634797/article/details/100560118
    }
}
