package com.dmenca.spb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages = {"com.dmenca"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}