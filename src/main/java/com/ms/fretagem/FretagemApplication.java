package com.ms.fretagem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class FretagemApplication {

    public static void main(String[] args) {
        SpringApplication.run(FretagemApplication.class, args);
    }

}
