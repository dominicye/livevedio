package com.ways.live;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class SbootdataApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbootdataApplication.class, args);
	}
}
