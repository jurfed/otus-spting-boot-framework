package ru.jurfed.springbootproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ru.jurfed.springbootproject.service.ServiceInterface;
import ru.jurfed.springbootproject.user.SimpleUser;


@EnableAspectJAutoProxy
@SpringBootApplication
public class SpringBootProjectApplication {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootProjectApplication.class, args);

		ServiceInterface myService = (ServiceInterface) context.getBean("myService1");

		myService.enterYouName();
		myService.startTests();
	}

}
