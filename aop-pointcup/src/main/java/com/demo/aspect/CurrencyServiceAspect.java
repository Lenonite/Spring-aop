package com.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class CurrencyServiceAspect {
//    @Before("this(com.demo.service.CurrencyServiceImpl)")
    public void beforeCurrencyAdvice(JoinPoint joinPoint){
        System.out.println(String.format("%s is invoked before with :%s",
                                        joinPoint.getSignature().getName(),
                                        Arrays.toString(joinPoint.getArgs())));
    }
}
