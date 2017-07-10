package net.antra.design.singleton;

public class SingletonD {
	private static volatile SingletonD instance= null;
	private SingletonD(){}
	public static SingletonD getInstance(){
		if(instance == null){
			synchronized(SingletonD.class){
				if(instance == null){
					instance = new SingletonD();
				}
			}
		}
		return instance;
	}
}
