package com.lunarshade.aopdemo;

import com.lunarshade.aopdemo.dao.AccountDAO;
import com.lunarshade.aopdemo.dao.MembershipDAO;
import com.lunarshade.aopdemo.entity.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DaoDemoConfig.class);
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
        Account account = new Account();
        accountDAO.addAccount(account, false);
        accountDAO.setName("John");
        accountDAO.getName();
        membershipDAO.addMember();
        membershipDAO.doWork();
        context.close();
    }
}
