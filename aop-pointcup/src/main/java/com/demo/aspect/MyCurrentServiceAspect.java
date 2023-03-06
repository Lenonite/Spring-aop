package com.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class MyCurrentServiceAspect {
    @Pointcut("within(com.demo.service.*)")
    public void withinPointCUt(){


    }
    @Pointcut("@annotation(com.demo.annotation.InTransaction)")
    public void annotationWithinPointCut(){


    }
    //@Before("annotationWithinPointCut()")
    public void beforeWithinAdvice(JoinPoint joinPoint){
        System.out.println(String.format("%s is invoked before with :%s",
                joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs())));
    }
    @Pointcut("bean(my_bean)")
    public void beanpointCUt(){}
   // @Before("beanpointCUt()")
    public void BeanBeforeAdvice(JoinPoint joinPoint){
        System.out.println(String.format("%s is invoked before with :%s",
                joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs())));
    }
    @Pointcut("args(int,double)")
    public void argPointcut(){}
//    @Before("argPointcut()")
    @Pointcut("@target(com.demo.annotation.Secured)")
    public void targetPointcut(){}
    @Pointcut("execution(public void com.demo.service.MyCurrencyService.changeCurrency(..))")
    public void  changeCurrencyPoint(){}
    @Before("changeCurrencyPoint()")
    public void executionBeforeAdvice(JoinPoint joinPoint){
        System.out.println(String.format("%s is invoked before with :%s",
                joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs())));
    }

    @Before("targetPointcut()")
    public void targetAnnotationAdvice(JoinPoint joinPoint){
        System.out.println(String.format("%s is invoked before with :%s",
                joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs())));
    }
    public void argsBeforeAdvice(JoinPoint joinPoint){
        System.out.println(String.format("%s is invoked before with :%s",
                joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs())));
    }
    @Pointcut("@args(com.demo.annotation.Validated)")
    public void AnnotationargsPointcut(){}
    @AfterThrowing(value="AnnotationargsPointcut()",throwing = "exception")
    public void afterthrowinAdvice(JoinPoint joinPoint,Exception exception){
        System.out.println(String.format("%s is invoked before with :%s and  exception",
                joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs())

        ));
    }
    //@AfterReturning(value= "AnnotationargsPointcut()",returning = "name")
    public void afterReturningAdvice(JoinPoint joinPoint, String name){

        System.out.println(String.format("%s is invoked before with :%s and return value :[%S]",
                joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs()),name

        ));
    }


   // @Before("AnnotationargsPointcut()")
    public void annontationargsBeforeAdvice(JoinPoint joinPoint){
        System.out.println(String.format("%s is invoked before with :%s",
                joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs())));
    }


//    @Before("withinPointCUt()")
    public void beforeCurrencyAdvice(JoinPoint joinPoint){
        System.out.println(String.format("%s is invoked before with :%s",
                joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs())));

    }
}
