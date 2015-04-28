package com.richard.memorystore.rest;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.richard.memorystore.tcp.TcpServer;
import com.richard.memorystore.udp.UDPServerBasic;

@ComponentScan
@EnableAutoConfiguration
@Configuration
public class Application {

    public static void main(String[] args) {
        //SpringApplication.run(Application.class, args);

        TcpServer.main();
//        
//        try {
//            UDPServerBasic.main(null);
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
    }
}