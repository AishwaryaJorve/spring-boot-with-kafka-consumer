package com.aish.Springbootwithkafkaconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWithKafkaConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithKafkaConsumerApplication.class, args);
		System.out.println("Consumer started");
	}

}
