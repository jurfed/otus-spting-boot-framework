package ru.jurfed.springbootproject.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("ru.jurfed.springbootproject.service")
public class ServiceConfig {
}
