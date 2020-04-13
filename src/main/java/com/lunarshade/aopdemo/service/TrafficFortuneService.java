package com.lunarshade.aopdemo.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService {

    public String getFortune() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        return "Expect heavy traffic this morning";
    }
}
