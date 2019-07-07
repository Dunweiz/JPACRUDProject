package com.skilldistillery.pethouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.skilldistillery.jpapethouse")
public class PetHouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetHouseApplication.class, args);
	}

}
