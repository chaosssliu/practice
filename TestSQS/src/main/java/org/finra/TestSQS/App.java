package org.finra.TestSQS;

import java.util.List;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	AWSCredentials credentials = new BasicAWSCredentials("AKIAJHYCP4L3IFBL2SKQ", "Dc9JZzMKSSmuYMUVqQL6HicAIth5A8g7tV9eF0bw");
    	AmazonSQSClient sqs = new AmazonSQSClient(credentials);
    	sqs.setEndpoint("https://sqs.us-east-1.amazonaws.com");
    	String myQueueUrl = sqs.getQueueUrl("TestQueue.fifo").getQueueUrl();
    	SendMessageRequest sendMessageRequest = new SendMessageRequest()
    			.withQueueUrl(myQueueUrl)
    			.withMessageBody("this is second message");
    	//sqs.sendMessage(sendMessageRequest);
    	sendMessageRequest.setMessageGroupId("1");
    	sendMessageRequest.setMessageDeduplicationId("1");
    	SendMessageResult sendMessageResult = sqs.sendMessage(sendMessageRequest);
    	String sequenceNumber = sendMessageResult.getSequenceNumber();
    	String messageId = sendMessageResult.getMessageId();
    	System.out.println(messageId + " " + sequenceNumber);
    	
    	List<Message> messages = sqs.receiveMessage(myQueueUrl).getMessages();
    	for (Message m : messages) {
    		System.out.println(m.getBody());
    	}
        System.out.println( "Hello World!" );
    }
}
