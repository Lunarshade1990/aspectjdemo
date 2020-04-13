package com.lunarshade.aopdemo.aspect;

import com.lunarshade.aopdemo.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Before("com.lunarshade.aopdemo.aspect.AopExpressions.forDaoPackageNoGettersAndSetters()")
    public void beforeAddAccount(JoinPoint joinPoint) {
        System.out.println("======>>> Executing @Before advice on addAccount()");

        MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();
        System.out.println("@BeforeReturning: " + methodSig);

        Object[] args = joinPoint.getArgs();
        Arrays.stream(args)
                .filter(arg -> arg instanceof Account)
                .map(arg  -> (Account) arg)
                .forEach(account -> {
                    System.out.println("Account name: " + account.getName());
                    System.out.println("Servicecode: " + account.getServiceCode());
                });
    }

    @AfterReturning(pointcut = "com.lunarshade.aopdemo.aspect.AopExpressions.forDaoPackageNoGettersAndSetters()",
                    returning = "result")
    public void afterReturningAccountsAdvise(JoinPoint joinPoint, List<Account> result) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("======>>> Executing @AfterReturning onMethod: " + method);
        System.out.println("======>>> Result is: " + result);

       convertAccountNamesToUpperCase(result);
        System.out.println("======>>> New result is: " + result);
    }

    @After("com.lunarshade.aopdemo.aspect.AopExpressions.forDaoPackageNoGettersAndSetters()")
    public void afterAccountAdvise(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("======>>> Executing @AfterOnMethod");
    }

    @AfterThrowing(pointcut = "com.lunarshade.aopdemo.aspect.AopExpressions.forDaoPackageNoGettersAndSetters()",
            throwing = "exeption")
    public void afterThrowingAccountAdvise(JoinPoint joinPoint, Throwable exeption) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("======>>> Executing @AfterThrowing onMethod: " + exeption);
    }

    private void convertAccountNamesToUpperCase(List<Account> accounts) {
        accounts.stream()
                .forEach(account -> {
                    account.setName(account.getName().toUpperCase());
                });
    }
}
