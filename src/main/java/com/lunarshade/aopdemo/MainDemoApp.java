package com.lunarshade.aopdemo;

import com.lunarshade.aopdemo.dao.AccountDAO;
import com.lunarshade.aopdemo.dao.MembershipDAO;
import com.lunarshade.aopdemo.entity.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class MainDemoApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DaoDemoConfig.class);
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        List<Account> accounts;
        try {
            boolean flag = false;
            accounts = accountDAO.findAccounts(flag);
        } catch (Exception e) {
            System.out.println("Main program. Catch Exception: " + e);
        }
        context.close();
    }
}
