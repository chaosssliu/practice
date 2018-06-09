package org.finra.SQSProcess;

import java.util.List;
import java.util.StringTokenizer;

import com.amazonaws.services.sqs.model.Message;

public class SQSIntegerListManager implements Runnable {

	private String queueUrl;
	public static void main(String[] args) {
		AWSSimpleQueueServiceUtil awssqsUtil = AWSSimpleQueueServiceUtil.getInstance();
//		awssqsUtil.createQueue(awssqsUtil.getQueueName());
		String queueUrl = awssqsUtil.getQueueUrl(awssqsUtil.getQueueName());
		System.out.println("queueUrl :" + queueUrl);
		
		IntegerList intList = new IntegerList();
		intList.setFirstName("Owen");
		intList.setLastName("Liu");
		intList.setIntList("5,3,9,1,8");
		
//		awssqsUtil.sendMessageToQueue(queueUrl, intList.toString());
		
		Thread managerthread = new Thread(new SQSIntegerListManager(queueUrl), "T2");
		managerthread.start();
	}
	
	public SQSIntegerListManager(String queueUrl) {
		this.queueUrl = queueUrl;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		AWSSimpleQueueServiceUtil awssqsUtil = AWSSimpleQueueServiceUtil.getInstance();
		boolean flag = true;
		while (flag) {
			List<Message> messages = awssqsUtil.getMessageFromQueue(this.queueUrl);
			if (messages == null || messages.size() == 0) {
				try {
					System.out.println("waiting for new message in");
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				flag = false;
				for (Message message : messages) {
					String messageIntList = message.getBody();
					System.out.println("Int List to be processed : " + messageIntList);
					StringTokenizer intListTokenizer = new StringTokenizer(messageIntList, " ");
					String firstName = null;
					String lastName = null;
					String intList = null;
					
					firstName = intListTokenizer.nextToken();
					lastName = intListTokenizer.nextToken();
					intList = intListTokenizer.nextToken();
					System.out.println("first name : " + firstName);
					System.out.println("last name : " + lastName);
					System.out.println("int list : " + intList);
						
					System.out.println("processed int list : " + ListProcessor.listProcess(firstName, lastName, intList));
				}
				
				for (Message message : messages) {
					awssqsUtil.deleteMessageFromQueue(this.queueUrl, message);
				}
			}
		}
	}
	
	
}
