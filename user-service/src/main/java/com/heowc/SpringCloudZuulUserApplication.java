package com.heowc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringCloudZuulUserApplication {

    @GetMapping("/{username}")
    public String getUsername(@PathVariable String username) {
        return String.format("Hello %s!", username);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudZuulUserApplication.class, args);
    }
}
