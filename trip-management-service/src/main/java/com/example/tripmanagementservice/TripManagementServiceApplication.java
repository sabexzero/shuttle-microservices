package com.example.tripmanagementservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TripManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TripManagementServiceApplication.class, args);
	}

}
