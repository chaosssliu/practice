package com.antra.jms.thread;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class HelloWorldConsumerThread implements Runnable, ExceptionListener {
	
	public void run() {
		
		try {
			
			ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
			
			Connection connection = connectionFactory.createConnection();
			connection.start();
			
			connection.setExceptionListener(this);
			
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			Destination destination = session.createQueue("HELLOWORLD.TESTQ");
			
			MessageConsumer consumer = session.createConsumer(destination);
			
			Message message = consumer.receive(1000);
			
			if (message instanceof TextMessage) {
				TextMessage textMessage = (TextMessage) message;
				String text = textMessage.getText();
				System.out.println("Receive: " + text);
			} else {
				System.out.println("Receive: " + message);
			}
			
			consumer.close();
			session.close();
			connection.close();
			
		} catch (Exception e) {
			System.out.println("Caught: " + e);
			e.printStackTrace();
		}
		
	}
	
	public synchronized void onException(JMSException ex) {
		System.out.println("JMS Exception occured. Shutting down client.");
	}

}
