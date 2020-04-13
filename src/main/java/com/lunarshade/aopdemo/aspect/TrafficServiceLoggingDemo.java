package com.lunarshade.aopdemo.aspect;

import com.lunarshade.aopdemo.service.TrafficFortuneService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class TrafficServiceLoggingDemo {

    Logger logger = Logger.getLogger(TrafficFortuneService.class.getName());

    @Around("com.lunarshade.aopdemo.aspect.AopExpressions.getTrafficFortuneServicePointcut()")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        String method = proceedingJoinPoint.getSignature().toShortString();

        logger.info("======>>> Executing @Around advice on method() " + method);

        long begin = System.currentTimeMillis();

        Object result = proceedingJoinPoint.proceed();

        long end = System.currentTimeMillis();

        long duration = end - begin;

        logger.info("======>>> Duration: " + duration/1000.0 + " seconds");

        return result;
    }
}
