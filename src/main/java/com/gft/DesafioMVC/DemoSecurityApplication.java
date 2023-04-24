package com.gft.DesafioMVC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gft.DesafioMVC.service.EmailService;

@SpringBootApplication
public class DemoSecurityApplication {

	public static void main(String[] args) {
		//System.out.println(new BCryptPasswordEncoder().encode("Gft@1234"));

		SpringApplication.run(DemoSecurityApplication.class, args);
	}
	
	@Autowired
	EmailService service;
	
}
