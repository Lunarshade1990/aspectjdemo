package com.lunarshade.aopdemo.dao;

import com.lunarshade.aopdemo.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

    public void addAccount(Account account, boolean flag) {
        System.out.println(getClass().getSimpleName()+ ": Doing my db work at account...!");
    }

    public String getName() {
        System.out.println("Name is: " + name);
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("name set: " + name);
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }
}
