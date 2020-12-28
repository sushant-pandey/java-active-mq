package com.pandeys.spring.jms.product.async.withspringannotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;


public class SpringMessageSender {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		SpringAsyncProductSender messageSender = context.getBean(SpringAsyncProductSender.class);
		Product product1 = new Product(101, "ProductA", 1001);
		Product product2 = new Product(102, "ProductB", 1002);
		Product product3 = new Product(103, "ProductC", 1003);
		messageSender.sendMessage(product1);
		messageSender.sendMessage(product2);
		messageSender.sendMessage(product3);
		context.close();
	}

}
