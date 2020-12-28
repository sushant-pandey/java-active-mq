package com.pandeys.spring.jms.product.async;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.pandeys.spring.jms.AppConfig;

public class AsyncMessageSender {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Product product = new Product(101, "ProductB", 1001);
		MessageAsyncProductSender messageSender = context.getBean(MessageAsyncProductSender.class);
		messageSender.sendMessage(product);
		context.close();
	}

}
