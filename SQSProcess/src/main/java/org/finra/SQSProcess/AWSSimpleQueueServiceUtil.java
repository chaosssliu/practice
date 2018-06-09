package org.finra.SQSProcess;

import java.util.List;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.CreateQueueRequest;
import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.GetQueueUrlRequest;
import com.amazonaws.services.sqs.model.ListQueuesResult;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;

public class AWSSimpleQueueServiceUtil {

	private BasicAWSCredentials credentials;
	private AmazonSQS sqs;
	private String simpleQueue;
	private static volatile AWSSimpleQueueServiceUtil awssqsUtil = new AWSSimpleQueueServiceUtil();
	
	private AWSSimpleQueueServiceUtil() {
		this.credentials = new BasicAWSCredentials("AKIAJHYCP4L3IFBL2SKQ", "Dc9JZzMKSSmuYMUVqQL6HicAIth5A8g7tV9eF0bw");
		this.simpleQueue = "testQueue";
		this.sqs = new AmazonSQSClient(this.credentials);
		this.sqs.setEndpoint("https://sqs.us-east-1.amazonaws.com");
	}
	
	public static AWSSimpleQueueServiceUtil getInstance() {
		return awssqsUtil;
	}
	
	public AmazonSQS getAWSClient() {
		return awssqsUtil.sqs;
	}
	
	public String getQueueName() {
		return awssqsUtil.simpleQueue;
	}
	
	public String createQueue(String queueName) {
		CreateQueueRequest createQueueRequest = new CreateQueueRequest(queueName);
		String queueUrl = this.sqs.createQueue(createQueueRequest).getQueueUrl();
		return queueUrl;
	}
	
	public String getQueueUrl(String queueName) {
		GetQueueUrlRequest getQueueUrlRequest = new GetQueueUrlRequest(queueName);
		return this.sqs.getQueueUrl(getQueueUrlRequest).getQueueUrl();
	}
	
	public ListQueuesResult listQueues() {
		return this.sqs.listQueues();
	}
	
	public void sendMessageToQueue(String queueUrl, String message) {
		SendMessageResult messageResult = this.sqs.sendMessage(new SendMessageRequest(queueUrl, message));
		System.out.println(messageResult.toString());
	}
	
	public List<Message> getMessageFromQueue(String queueUrl) {
		ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(queueUrl);
		List<Message> messages = this.sqs.receiveMessage(receiveMessageRequest).getMessages();
		return messages;
	}
	
	public void deleteMessageFromQueue(String queueUrl, Message message) {
		String messageReceiptHandle = message.getReceiptHandle();
		System.out.println("message deleted : " + message.getBody() + "." + message.getReceiptHandle());
		this.sqs.deleteMessage(new DeleteMessageRequest(queueUrl, messageReceiptHandle));
	}
}
