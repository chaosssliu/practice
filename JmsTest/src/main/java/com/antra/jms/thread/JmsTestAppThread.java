package com.antra.jms.thread;

public class JmsTestAppThread {

	public static void main(String[] args) throws Exception {

		thread(new HelloWorldProducerThread(), false);
        thread(new HelloWorldProducerThread(), false);
        thread(new HelloWorldProducerThread(), false);
        thread(new HelloWorldProducerThread(), false);
        Thread.sleep(1000);
        // 1 consumer
        thread(new HelloWorldConsumerThread(), false);
        thread(new HelloWorldProducerThread(), false);
        // 2 consumer
        thread(new HelloWorldConsumerThread(), false);
        thread(new HelloWorldProducerThread(), false);
        // 3 consumer
        thread(new HelloWorldConsumerThread(), false);
        //4 consumer
        thread(new HelloWorldConsumerThread(), false);
        Thread.sleep(1000);

	}
	
	public static void thread(Runnable runnable, boolean daemon) {
		Thread newThread = new Thread(runnable);
		newThread.setDaemon(daemon);
		newThread.start();
	}

}
