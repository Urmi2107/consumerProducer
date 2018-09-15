package com.capgemini.commentStoreProducer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class CommentStoreProducerApplication {
	private static final Logger logger = LoggerFactory.getLogger(CommentStoreProducerApplication.class);
	public static void main(String[] args) {
		
		SpringApplication.run(CommentStoreProducerApplication.class, args);
		logger.debug("--Application Started--");
		logger.warn("--Warning!!--");
		logger.error("--Error--");
		logger.info("--Information--");
		
	}
}
