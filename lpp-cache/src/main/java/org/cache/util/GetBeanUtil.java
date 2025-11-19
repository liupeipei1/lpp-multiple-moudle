package org.cache.util;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

@Service
/*
 application Context获取类
 */
public class GetBeanUtil extends AnnotationConfigApplicationContext {


    private  String path= "com/example/common/util";

    public  GetBeanUtil(){
        System.out.printf("GetBeanUtil===构造函数");//     context.refresh();
    }
    //通过类名获取对象bean
    public Object getBeanByAnnotation(String className){
        System.out.printf("GetBeanUtil===实例方法getBeanByAnnotation");//     context.refresh();
        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(path);
        return context.getBean(className);

    }
    //获取所有的bean
    public String[] getAllBeanByAnnotation(){
        System.out.printf("GetBeanUtil===实例方法getAllBeanByAnnotation");//     context.refresh();
       AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(path);   //     context.refresh();
        return context.getBeanDefinitionNames();
    }


}
