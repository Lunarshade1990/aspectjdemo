package com.lunarshade.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {

    @Before("com.lunarshade.aopdemo.aspect.AopExpressions.forDaoPackage()")
    public void logToCloud() {
        System.out.println("======>>> Logging to Cloud in async fashion");
    }

}
