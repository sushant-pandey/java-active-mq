package com.pandeys.messagereceiver;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.spring.ActiveMQConnectionFactory;

public class ReadTextMessageToQueue {

	private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
	private static String queueName = "com.pandeys.textMsgQueue";
	
	public static void main(String[] args) throws JMSException {
		System.out.println("URL : " + url);
		ConnectionFactory connFactory = new ActiveMQConnectionFactory();
		Connection conn = connFactory.createConnection();
		conn.start();
		
		Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		Destination destination = session.createQueue(queueName);
		
		MessageConsumer consumer = session.createConsumer(destination);
		Message message = consumer.receive();
		if(message instanceof TextMessage) {
			System.out.println("Message Read : " + ((TextMessage)message).getText());
		}
		
		conn.close();
		
	}

}
