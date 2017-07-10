package com.antra.jms;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class HelloWorldConsumer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			// create a ConnectionFactory
			ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
			
			
			// create a connection
			Connection connection = connectionFactory.createConnection();
			connection.start();
			
			// create a session
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			// create the destination
			Destination destination = session.createQueue("HELLOWORLD.TESTQ");
			
			// create the messageConsumer from the session
			MessageConsumer consumer = session.createConsumer(destination);
			
			// wait for a message for one sec
			Message message = consumer.receive(1000);
			
			if (message instanceof TextMessage) {
				TextMessage textMessage = (TextMessage) message;
				String text = textMessage.getText();
				System.out.println("Received: " + text);
			} else {
				System.out.println("Received: " + message);
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
