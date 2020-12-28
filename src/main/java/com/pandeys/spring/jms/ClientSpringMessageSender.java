package com.pandeys.spring.jms;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class ClientSpringMessageSender {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		MessageSender messageSender = context.getBean(MessageSender.class);
		messageSender.sendMessage("Hi! This is first spring message");
		context.close();
	}

}
