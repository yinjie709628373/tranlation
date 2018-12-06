package com.example.demo;

import com.example.demo.utils.PoiTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class DemoApplication {

    public static void main(String[] args) throws  Exception{
        //SpringApplication.run(DemoApplication.class, args);
        PoiTest.TT();
    }
}
