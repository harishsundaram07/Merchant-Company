package com.harishtest.merchantdetails.merchantcompany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class MerchantCompanyStarter {

	public static void main(String[] args) {
	
		//Starter service
		SpringApplication.run(MerchantCompanyStarter.class, args);

	}

}
