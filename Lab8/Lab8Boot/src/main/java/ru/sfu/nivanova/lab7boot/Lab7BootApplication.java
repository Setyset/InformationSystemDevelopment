package ru.sfu.nivanova.lab7boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class Lab7BootApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab7BootApplication.class, args);
    }


}
