package com.hm.outfit;

import com.azure.spring.data.cosmos.repository.config.EnableCosmosRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableCosmosRepositories
public class OutfitApplication {

	public static void main(String[] args) {
		SpringApplication.run(OutfitApplication.class, args);
	}

}
