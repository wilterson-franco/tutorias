package com.wilterson.tutorial.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class SampleSpringCloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleSpringCloudConfigServerApplication.class, args);
	}

}
