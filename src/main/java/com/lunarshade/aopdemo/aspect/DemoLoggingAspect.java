package com.lunarshade.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {

    @Pointcut("execution(* com.lunarshade.aopdemo.dao.*.*(..))")
    private void forDaoPackage() {}

    //Create pointcuts for getters and setters
    @Pointcut("execution(* com.lunarshade.aopdemo.dao.*.get*(..))")
    private void getPointcut() {}
    @Pointcut("execution(* com.lunarshade.aopdemo.dao.*.set*(..))")
    private void setPointcut() {}

    @Pointcut("forDaoPackage() && !(getPointcut() || setPointcut())")
    private void forDaoPackageNoGettersAndSetters () {};

    @Before("forDaoPackageNoGettersAndSetters()")
    public void beforeAddAccount() {
        System.out.println("======>>> Executing @Before advice on addAccount()");
    }

    @Before("forDaoPackage()")
    public void performAnalytics() {
        System.out.println("======>>> Executing @Before advice on addAccount()");
    }
}
