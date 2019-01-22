package com.chepiv.rentspot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class RentspotApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentspotApplication.class, args);
    }

}

