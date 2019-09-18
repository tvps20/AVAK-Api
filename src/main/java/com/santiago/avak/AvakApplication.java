package com.santiago.avak;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AvakApplication implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(AvakApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
