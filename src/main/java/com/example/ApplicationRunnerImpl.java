package com.example;


import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import server.ServerListener;

@Component
public class ApplicationRunnerImpl implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("socket start");
        new ServerListener().start();
    }
}