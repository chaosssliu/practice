package net.antra.design.singleton;

public class ThreadOfGetSingleton extends Thread{

	@Override
	public void run() {
		System.out.println(SingletonD.getInstance());
	}
	
}
