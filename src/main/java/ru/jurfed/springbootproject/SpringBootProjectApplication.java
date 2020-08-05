package ru.jurfed.springbootproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.jurfed.springbootproject.service.ServiceInterface;

@SpringBootApplication
public class SpringBootProjectApplication {

	public static void main(String[] args){
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootProjectApplication.class, args);
		ServiceInterface myService = (ServiceInterface) context.getBean("simpleService");
		myService.start();
	}

}
