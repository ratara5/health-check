package org.health.healthcheck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class HealthCheckApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthCheckApplication.class, args);
	}

}
