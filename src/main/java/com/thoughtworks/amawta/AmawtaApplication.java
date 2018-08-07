package com.thoughtworks.amawta;

import com.google.common.collect.ImmutableMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AmawtaApplication {

    public static void main(String[] args) {
        //SpringApplication.run(AmawtaApplication.class, args);

        SpringApplication app = new SpringApplication(AmawtaApplication.class);
        app.setDefaultProperties(ImmutableMap.of("spring.profiles.default", Constants.ENV_DEVELOPMENT));
        app.run(args);
    }
}
