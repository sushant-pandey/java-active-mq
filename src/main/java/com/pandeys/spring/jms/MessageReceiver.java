package com.pandeys.spring.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

	@Autowired
	@Qualifier("jmsTemplate")
	public JmsTemplate jmsTemplate;
	
	@Autowired
	@Qualifier("messageConvertor")
	public MessageConverter messageConvertor;
	
	public String receiveMessage() {
		Message receivedMessage = jmsTemplate.receive();
		String textMessage = null;
		try {
			textMessage = 	(String)messageConvertor.fromMessage(receivedMessage);
		} catch (MessageConversionException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		}
		return textMessage;
	}
}
