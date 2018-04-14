package com.heowc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringCloudZuulProductApplication {

    @GetMapping("/{product}")
    public String orderProduct(@PathVariable String product) {
        return String.format("order %s.", product);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudZuulProductApplication.class, args);
    }
}
