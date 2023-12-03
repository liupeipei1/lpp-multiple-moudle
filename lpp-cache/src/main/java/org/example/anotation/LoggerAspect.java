package org.example.anotation;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Slf4j
@Component
public class LoggerAspect {


    @Pointcut("@annotation(LoggerForLpp)")
    public void annotionMethod() {

    }

    @Around("annotionMethod()")
    public Object logMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopwatch = new StopWatch();
        stopwatch.start();
        String method = joinPoint.getSignature().getName();//得到方法
        String className = joinPoint.getTarget().getClass().getSimpleName();
        log.info("========" + className + "." + method + "====begin");
        Object obj = joinPoint.proceed();
        stopwatch.stop();
        double second = stopwatch.getTotalTimeSeconds();
        log.info("========" + className + "." + method + "====end  耗时" + second);
        return obj;
    }
}
