package com.hong.hongmmunity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HongmmunityApplication {
    public static void main(String[] args) {
        SpringApplication.run(HongmmunityApplication.class, args);
    }

}
