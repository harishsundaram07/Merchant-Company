package com.harishtest.merchantdetails.merchantcompany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@EnableConfigurationProperties
public class MerchantCompanyStarter extends SpringBootServletInitializer {

	public static void main(String[] args) {
	
		//Starter service
		SpringApplication.run(MerchantCompanyStarter.class, args);

	}
	
	@Override
	public SpringApplicationBuilder configure(SpringApplicationBuilder builder)
	{
		return builder.sources(MerchantCompanyStarter.class);
	}

}
