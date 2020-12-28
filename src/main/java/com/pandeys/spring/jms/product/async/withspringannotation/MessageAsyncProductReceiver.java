package com.pandeys.spring.jms.product.async.withspringannotation;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

@Component("messageAsyncProductReceiver")
public class MessageAsyncProductReceiver{

	private static final String QUEUE_NAME = "com.pandeys.textMsgQueue.springannotation";	
	
	@JmsListener(destination = QUEUE_NAME)
	public void receiveMessage(Message<Product> message) {
		MessageHeaders headers = message.getHeaders();
		System.out.println("Headers = " + headers);
		
		Product payload = message.getPayload();
		System.out.println("Payload");
		System.out.println(payload);
	}
}
