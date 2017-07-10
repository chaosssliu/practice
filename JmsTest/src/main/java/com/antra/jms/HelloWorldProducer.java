package com.antra.jms;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;




public class HelloWorldProducer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			// create a ConnectionFactory
			ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
			
			// create a Connection
			Connection connection = connectionFactory.createConnection();
			connection.start();
			
			// create a Session
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			// create the destination
			Destination destination = session.createQueue("HELLOWORLD.TESTQ");
			
			// create a MessageProducer from the Session on the Topic or Queue
			MessageProducer producer = session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			
			// create a message
			String text = "Hello World! From: " + Thread.currentThread().getName();
			TextMessage textMessage = session.createTextMessage(text);
			
			// tell the producer to send message
			System.out.println("Send Message: " + textMessage.hashCode() + " + " + Thread.currentThread().getName());
			producer.send(textMessage);
			
			// clean up
			session.close();
			connection.close();
			
		} catch (Exception e) {
			System.out.println("Caught: " + e);
			e.printStackTrace();
		}
	}

}
