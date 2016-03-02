package com.rest.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * An entry point. This class is a start up class which is responsible for bootstrapping the whole
 * sample application.
 */
@SpringBootApplication
public class Bootstrap {

    public static void main(final String[] commandLineArgs) {
        SpringApplication.run(Bootstrap.class, commandLineArgs);
    }
}
