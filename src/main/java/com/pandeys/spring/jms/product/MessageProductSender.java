package com.pandeys.spring.jms.product;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class MessageProductSender {

	@Autowired
	@Qualifier("jmsTemplate")
	public JmsTemplate jmsTemplate;
	
	public void sendMessage(final Product productObj) {
		MessageCreator messageCreator = new MessageCreator() {
			
			public Message createMessage(Session session) throws JMSException {
				ObjectMessage objMessage = session.createObjectMessage(productObj);
				return objMessage;
			}
		};
		
		jmsTemplate.send(messageCreator);
	}
}
