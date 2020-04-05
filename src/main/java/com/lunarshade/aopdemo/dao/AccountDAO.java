package com.lunarshade.aopdemo.dao;

import com.lunarshade.aopdemo.entity.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

    public void addAccount(Account account, boolean flag) {
        System.out.println(getClass().getSimpleName()+ ": Doing my db work at account...!");
        System.out.println();
    }

    public List<Account> findAccounts(boolean flag) {

        if (flag) {
            throw new RuntimeException("No soup for you!!!");
        }

        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("name1", "code1"));
        accounts.add(new Account("name2", "code2"));
        accounts.add(new Account("name3", "code3"));

        return accounts;

    }

    public String getName() {
        System.out.println("Name is: " + name);
        System.out.println();
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("name set: " + name);
        System.out.println();
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }
}
