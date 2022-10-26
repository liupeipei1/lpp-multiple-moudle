package com.example.Aop;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)//指定切面的优先级
@Component
@EnableAspectJAutoProxy //使aspect起作用 自动匹配代理对象
/*
任意公共方法的执行：execution(public * *(..))
任何一个以“set”开始的方法的执行：execution(* set*(..))
AccountService 接口的任意方法的执行：execution(* com.xyz.service.AccountService.*(..))
定义在service包里的任意方法的执行： execution(* com.xyz.service.*.*(..))
定义在service包和所有子包里的任意类的任意方法的执行：execution(* com.xyz.service..*.*(..))
第一个*表示匹配任意的方法返回值execution(*  ， ..(两个点)表示零个或多个参数，第一个..表示service包及其子包,第二个*表示所有类, 第三个*表示所有方法，第二个..表示方法的任意参数个数
 */
public class LogAspect {

    // @Pointcut("execution(* com.example.springbootproject.Controller.TestController.*(..))")//TestController 接口的任意方法的执行
    //@Pointcut("execution(* com.example.springbootproject.Controller.*.*(..))")//定义在Controller包里的任意方法的执行
    @Pointcut("execution(* com.example.Controller.*.*(..))")//定义在Controller包里所有类，所有的方法的任意方法的执行
    public void apilog() {
    }

    @Before("apilog()")
    public void doBefore() {
        System.out.println("Before方法执行");
    }

    @After("apilog()")
    public void doAfter() {
        System.out.println("after方法执行");
    }


    @Around("apilog()") //这里必须有返回对象，否则切面接口 void就会出现无返回
    public Object logArround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        System.out.println("环绕前入参:" + JSON.toJSONString(args[0]));
        System.out.println(joinPoint.getSignature());
        Object proceed = joinPoint.proceed();
        System.out.println("出参：" + JSON.toJSONString(proceed));
        System.out.println("环绕后");
        return proceed;
    }

}
