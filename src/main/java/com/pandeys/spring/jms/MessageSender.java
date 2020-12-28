package com.pandeys.spring.jms;

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
public class MessageSender {

	@Autowired
	@Qualifier("jmsTemplate")
	public JmsTemplate jmsTemplate;
	
	public void sendMessage(final String message) {
		MessageCreator messageCreator = new MessageCreator() {
			
			public Message createMessage(Session session) throws JMSException {
//				TextMessage objMessage = session.createTextMessage(message);
				ObjectMessage objMessage = session.createObjectMessage(message);
				return objMessage;
			}
		};
		
		jmsTemplate.send(messageCreator);
	}
}
