package com.pandeys.spring.jms.product.async.withspringannotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.pandeys.spring.jms.product.async.withspringannotation")
@Import({MessageAsyncSpringConfiguration.class, MessageListenerConfiguration.class})
public class AppConfig {

}
