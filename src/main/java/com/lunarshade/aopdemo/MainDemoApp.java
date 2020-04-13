package com.lunarshade.aopdemo;

import com.lunarshade.aopdemo.dao.AccountDAO;
import com.lunarshade.aopdemo.dao.MembershipDAO;
import com.lunarshade.aopdemo.entity.Account;
import com.lunarshade.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MainDemoApp {

    private static Logger myLogger = Logger.getLogger(MainDemoApp.class.getName());

    public static void main(String[] args) throws InterruptedException {


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DaoDemoConfig.class);
        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        myLogger.info("Main Program: AroundDemo");
        myLogger.info("Calling get fortune");
        String data = trafficFortuneService.getFortune();
        myLogger.info("My fortune is: " + data);
        myLogger.info("finished");
        context.close();

    }
}
