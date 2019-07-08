package com.skilldistillery.pethouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@EntityScan("com.skilldistillery.pethouse")
public class PetHouseApplication extends SpringBootServletInitializer {

	@Override
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	    return application.sources(PetHouseApplication.class);
	  }
	public static void main(String[] args) {
		SpringApplication.run(PetHouseApplication.class, args);
	}

}
