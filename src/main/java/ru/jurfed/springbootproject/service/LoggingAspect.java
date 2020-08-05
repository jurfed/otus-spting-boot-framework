package ru.jurfed.springbootproject.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* SimpleService.*(..))")
    public void logBefore(JoinPoint joinPoint){
        System.out.println("execution Вызов метода " + joinPoint.getSignature().getName());
    }

    @After("within(ru.jurfed.springbootproject.service..*)")
    public void logBefore2(JoinPoint joinPoint){
        System.out.println("within Вызов метода " + joinPoint.getSignature().getName());
    }

}
