package net.antra.design.singleton;

public class SingletonC {
	private static SingletonC instance= null;
	private SingletonC(){}
	public synchronized static SingletonC getInstance(){
		if(instance == null){
			instance = new SingletonC();
		}
		return instance;
	}
}
