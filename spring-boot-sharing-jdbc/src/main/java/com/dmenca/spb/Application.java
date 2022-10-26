package com.dmenca.spb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceConfiguration;

@SpringBootApplication(scanBasePackages = {"com.dmenca"})
@MapperScan(basePackages = {"com.dmenca.spb.mapper"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
