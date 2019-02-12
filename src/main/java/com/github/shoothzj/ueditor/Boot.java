package com.github.shoothzj.ueditor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.github.shoothzj.ueditor")
public class Boot extends SpringBootServletInitializer {

    private static final Logger log = LoggerFactory.getLogger(Boot.class);

    public static void main(String[] args) {
        SpringApplication.run(Boot.class);
    }

}
