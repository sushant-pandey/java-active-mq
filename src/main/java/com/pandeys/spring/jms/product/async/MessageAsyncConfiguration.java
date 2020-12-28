package com.pandeys.spring.jms.product.async;

import java.util.Arrays;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.MessageListenerContainer;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.SimpleMessageConverter;

@Configuration
public class MessageAsyncConfiguration {

	//"tcp://localhost:61616"
	private String url = ActiveMQConnection.DEFAULT_BROKER_URL;
	private String queueName = "com.pandeys.textMsgQueue";
	
	@Autowired
	@Qualifier("messageAsyncProductReceiver")
	private MessageAsyncProductReceiver msgProdReceiver;
	
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
	
	@Bean(name = "messageListenerContainer")
	public MessageListenerContainer getMessageListenerContainer() {
		DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
		container.setConnectionFactory(getConnectionFactory());
		container.setDestinationName(queueName);
		container.setMessageListener(msgProdReceiver);
		return container;
	}
	
	@Bean(name = "messageConvertor")
	public MessageConverter getMessageConverter() {
		return new SimpleMessageConverter();
	}
}
