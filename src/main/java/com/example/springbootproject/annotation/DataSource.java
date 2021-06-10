package com.example.springbootproject.annotation;


import java.lang.annotation.*;

@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited //（标明注解可继承）
public @interface DataSource {
    /**
     * 切换数据源名称
     */
    //public DataSourceType value() default DataSourceType.MASTER;
}
