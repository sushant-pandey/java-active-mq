package com.pandeys.spring.jms.product.async;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.pandeys.spring.jms.product.async")
@Import({MessageAsyncConfiguration.class})
public class AppConfig {

}
