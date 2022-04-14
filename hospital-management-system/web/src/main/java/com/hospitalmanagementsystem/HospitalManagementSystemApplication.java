package com.hospitalmanagementsystem;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.hospitalmanagementsystem.*"})
@EnableJpaRepositories(basePackages = {"com.hospitalmanagementsystem.*"})
@EntityScan(basePackages = {"com.hospitalmanagementsystem.*"})

public class HospitalManagementSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(HospitalManagementSystemApplication.class);
    }
}
