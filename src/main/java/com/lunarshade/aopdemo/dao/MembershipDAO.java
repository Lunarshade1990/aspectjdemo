package com.lunarshade.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
    public void addMember() {
        System.out.println(getClass().getSimpleName()+ ": Doing my db work at member...!");
    }

    public void doWork() {
        System.out.println(getClass().getSimpleName()+ ": Doing my work...!");
    }
}
