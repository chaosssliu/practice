package com.antra.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class JmsTemplateTest {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"com/antra/jms/JmsTemplateTest-context.xml");
		
		JmsTemplate template = (JmsTemplate) ctx.getBean("jmsTemplate");
		
		for (int i = 0; i < 10; i++) {
			
			template.send("SpringSendTestQueue", new MessageCreator() {
				
				public Message createMessage(Session session) throws JMSException {
					
					TextMessage textMessage = session.createTextMessage();
					
					textMessage.setText("This is a spring test message.");
					
					return textMessage;
				}
			});
			
			System.out.println("Message sent");
		}
		
		System.exit(1);

	}

}
