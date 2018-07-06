package com.p2.springboot.basics.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootBasicApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootBasicApplication.class, args);
		for(String beanName : context.getBeanDefinitionNames()){
			System.out.println(beanName);
		}
	}
}
