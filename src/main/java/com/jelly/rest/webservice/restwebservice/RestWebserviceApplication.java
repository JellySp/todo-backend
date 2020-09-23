package com.jelly.rest.webservice.restwebservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"com.jelly.rest.webservice.restwebservice"})
//@ComponentScan(basePackages = {"com.jelly.rest.webservice.restwebservice"})
public class RestWebserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestWebserviceApplication.class, args);
	}

}
