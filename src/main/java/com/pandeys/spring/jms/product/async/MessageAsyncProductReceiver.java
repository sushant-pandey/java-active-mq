package com.pandeys.spring.jms.product.async;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

@Component("messageAsyncProductReceiver")
public class MessageAsyncProductReceiver implements MessageListener{

		
	@Autowired
	@Qualifier("messageConvertor")
	public MessageConverter messageConvertor;
	

	public void onMessage(Message message) {
		Product product = null;
		try {
			product = 	(Product)messageConvertor.fromMessage(message);
			System.out.println("Receiving Message");
			System.out.println(product);
			System.out.println("Receiving Finished");
		} catch (MessageConversionException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
