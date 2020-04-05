package com.lunarshade.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    @Pointcut("execution(* com.lunarshade.aopdemo.dao.*.*(..))")
    void forDaoPackage() {}

    //Create pointcuts for getters and setters
    @Pointcut("execution(* com.lunarshade.aopdemo.dao.*.get*(..))")
    void getPointcut() {}

    @Pointcut("execution(* com.lunarshade.aopdemo.dao.*.set*(..))")
    void setPointcut() {}

    @Pointcut("forDaoPackage() && !(getPointcut() || setPointcut())")
    void forDaoPackageNoGettersAndSetters () {};
}
