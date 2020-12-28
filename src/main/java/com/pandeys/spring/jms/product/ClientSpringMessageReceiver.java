package com.pandeys.spring.jms.product;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.pandeys.spring.jms.AppConfig;

public class ClientSpringMessageReceiver {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		MessageProductReceiver messageReceiver = context.getBean(MessageProductReceiver.class);
		System.out.println("Received Message");
		System.out.println(messageReceiver.receiveMessage());
		context.close();
	}

}
