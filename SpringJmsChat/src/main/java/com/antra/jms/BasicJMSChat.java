package com.antra.jms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

public class BasicJMSChat implements MessageListener{

	private JmsTemplate chatJMSTemplate;
	private Topic chatTopic;
	private static String userId;
	
	public static void main(String[] args) throws JMSException, IOException {

		if (args.length != 1) {
			System.out.println("User Name is required...");
		} else {
			userId = args[0];
			
			@SuppressWarnings("resource")
			ApplicationContext ctx = new ClassPathXmlApplicationContext("com/antra/jms/spring-config.xml");
			
			BasicJMSChat basicJMSChat = (BasicJMSChat) ctx.getBean("basicJMSChat");
			
			TopicConnectionFactory topConnectionFactory = (TopicConnectionFactory) basicJMSChat
					.chatJMSTemplate.getConnectionFactory();
			TopicConnection topicConnection = topConnectionFactory.createTopicConnection();
			
			basicJMSChat.publish(topicConnection, basicJMSChat.chatTopic, userId);
			basicJMSChat.subscribe(topicConnection, basicJMSChat.chatTopic, basicJMSChat);
		}
	}
	
	void subscribe(TopicConnection topicConnection, Topic chatTopic, BasicJMSChat commandLineChat) throws JMSException {
		TopicSession topicSession = topicConnection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
		TopicSubscriber topicSubscriber = topicSession.createSubscriber(chatTopic);
		topicSubscriber.setMessageListener(commandLineChat);
		
	}
	
	void publish(TopicConnection topicConnection, Topic chatTopic, String userId) throws JMSException, IOException {
		
		TopicSession topicSession = topicConnection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
		TopicPublisher topicPublisher = topicSession.createPublisher(chatTopic);
		topicConnection.start();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String messageToSend = reader.readLine();
			if (messageToSend.equalsIgnoreCase("exit")) {
				topicConnection.close();
				System.exit(0);
			} else {
				TextMessage textMessage = (TextMessage) topicSession.createTextMessage();
				textMessage.setText("\n[" + userId + " : " + messageToSend + "]");
				topicPublisher.publish(textMessage);
			}
		}
	}

	public JmsTemplate getChatJMSTemplate() {
		return chatJMSTemplate;
	}

	public void setChatJMSTemplate(JmsTemplate chatJMSTemplate) {
		this.chatJMSTemplate = chatJMSTemplate;
	}

	public Topic getChatTopic() {
		return chatTopic;
	}

	public void setChatTopic(Topic chatTopic) {
		this.chatTopic = chatTopic;
	}

	public void onMessage(Message message) {
		
		if (message instanceof TextMessage) {
			try {
				String messageText = ((TextMessage) message).getText();
				
				if (!messageText.startsWith("[" + userId)) {
					System.out.println(messageText);
				}
			} catch (JMSException jmsEx_p) {
				String errorMessage = "An error occured extracting message";
				jmsEx_p.printStackTrace();
			}
		} else {
			String errorMessage = "Message is not expected type TextMessage";
			System.err.println(errorMessage);
			throw new RuntimeException(errorMessage);
		}
		
	}

	
}
