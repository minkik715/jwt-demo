package io.github.minkik715.jwtdemo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;;


@SpringBootApplication
public class JwtDemoApplication {
    public static void main(String[] args)
    {
        new SpringApplicationBuilder(JwtDemoApplication.class)
                .run(args);
    }

}