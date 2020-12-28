package com.pandeys.spring.jms;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.pandeys.spring.jms")
@Import({MessageConfiguration.class})
public class AppConfig {

}
