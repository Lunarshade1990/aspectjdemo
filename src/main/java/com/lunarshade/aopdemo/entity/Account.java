package com.lunarshade.aopdemo.entity;

import lombok.ToString;

@ToString
public class Account {

    private String name;
    private String serviceCode;

    public Account(String name, String serviceCode) {
        this.name = name;
        this.serviceCode = serviceCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }
}
