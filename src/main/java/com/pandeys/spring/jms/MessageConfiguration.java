package com.pandeys.spring.jms;

import java.util.Arrays;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.SimpleMessageConverter;

@Configuration
public class MessageConfiguration {

	//"tcp://localhost:61616"
	private String url = ActiveMQConnection.DEFAULT_BROKER_URL;
	private String queueName = "com.pandeys.textMsgQueue";
	
	@Bean(name = "connectionFactory")
	public ConnectionFactory getConnectionFactory() {
		ActiveMQConnectionFactory connFactory = new ActiveMQConnectionFactory();
		connFactory.setBrokerURL(url);
		connFactory.setTrustedPackages(Arrays.asList("com.pandeys.spring.jms"));
		return connFactory;
	}
	
	@Bean(name = "jmsTemplate")
	public JmsTemplate getJmsTemplate() {
		JmsTemplate jmsTemplate = new JmsTemplate(getConnectionFactory());
		jmsTemplate.setDefaultDestinationName(queueName);
		return jmsTemplate;
	}
	
	@Bean(name = "messageConvertor")
	public MessageConverter getMessageConverter() {
		return new SimpleMessageConverter();
	}
}
