package com.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceLoggerAspect {
    @Around("@target(com.demo.annotation.Logger)")

    public Object perfomancelog(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        try {

            return joinPoint.proceed();
        } finally {
            long endTime = System.currentTimeMillis();

            System.out.println(String.format("%s take Times %s milliseconds",
                    joinPoint.getSignature().getName(),
                    (endTime - startTime)))
            ;
        }
    }

}
