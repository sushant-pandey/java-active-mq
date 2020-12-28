package com.pandeys.spring.jms;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class ClientSpringMessageReceiver {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		MessageReceiver messageReceiver = context.getBean(MessageReceiver.class);
		System.out.println("Received Message");
		System.out.println(messageReceiver.receiveMessage());
		context.close();
	}

}
