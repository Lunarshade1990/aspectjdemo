package com.lunarshade.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.lunarshade.aopdemo.aspect.AopExpressions;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {

    @Before("com.lunarshade.aopdemo.aspect.AopExpressions.forDaoPackage()")
    public void performAnalytics() {
        System.out.println("======>>> Performing API analytics");
    }

}
