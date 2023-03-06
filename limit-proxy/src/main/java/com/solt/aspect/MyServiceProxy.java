package com.solt.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;

@Aspect
@Component
public class MyServiceProxy {
    @Before("@within(com.solt.annotation.MyAlter)")
    public void beforeMyAlterServiceAdvice(JoinPoint joinPoint){
        System.out.println(
                String.format("%s is invoked before with %s",
                        joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()))
        );
    }
    @Before("target(com.solt.service.MyServiceImpl)")
    public  void beforeMyServiceAdvice(JoinPoint joinPoint){
        System.out.println(
                String.format("%s is invoked before with %s",
                        joinPoint.getSignature().getName(),
                        Arrays.toString(joinPoint.getArgs()))
        );
    }
}
