package com.vangaurd.coding.challenge.weather;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ComponentScan(basePackages = "com.vanguard")
@SpringBootApplication
public class WeatherApplication {

	private static Logger logger = LoggerFactory.getLogger(WeatherApplication.class);
			
	public static void main(String[] args) {
		
		SpringApplication.run(WeatherApplication.class, args);
		
		logger.info("###### WeatherApplication is up and running ##### ");
		
	}

}
