package com.springboot.learning.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    @Before("execution(* com.springboot.learning.service.*.*(..))")
    public void beforeMethod(){
        System.out.println("Before method called");
    }

    @After("execution(* com.springboot.learning.service.*.*(..))")
    public void afterMehthod(){
        System.out.println("After method called");
    }

    @Around("execution(* com.springboot.learning.service.*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("Around before");
        Object result = joinPoint.proceed();
        System.out.println("Around after");
        return result;
    }
}
