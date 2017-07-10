package com.antra.jms.thread;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class HelloWorldProducerThread implements Runnable {

	public void run() {
		
		try {
			
			ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
			
			Connection connection = connectionFactory.createConnection();
			connection.start();
			
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			Destination destination = session.createQueue("HELLOWORLD.TESTQ");
			
			MessageProducer producer = session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			
			String text = "Hello World! From: " + Thread.currentThread().getName() + " : " + this.hashCode();
			TextMessage textMessage = session.createTextMessage(text);
			
			System.out.println("Sent Message: " + textMessage.hashCode() + " : " + Thread.currentThread().getName());
			producer.send(textMessage);
			
			session.close();
			connection.close();
		} catch (Exception e) {
			System.out.println("Caught: " + e);
			e.printStackTrace();
		}
		
		
	}
}
