package net.antra.design.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonTest {
	public static void main(String[] args) {
		
		Runnable r = ()->System.out.println(SingletonB.getInstance());
		
		ExecutorService es = Executors.newFixedThreadPool(20);
		for(int i = 0 ; i < 20; i++){
			es.submit(r);
		}
		es.shutdown();
	}
}
