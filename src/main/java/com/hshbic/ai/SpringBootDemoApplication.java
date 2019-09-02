package com.hshbic.ai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;


//@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@SpringBootApplication
@EnableCaching
@ServletComponentScan
public class SpringBootDemoApplication {

    public static void main(String[] args) {
            SpringApplication.run(SpringBootDemoApplication.class, args);
            System.out.println("ai-mail-service  started  successful >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

}
