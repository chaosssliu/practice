package net.antra.design.factory;

public class FruitFactory {
	public Object createFruit(String name){
		Object obj = null;
		switch(name){
			case "apple":
				obj =  new Apple();
				break;
			case "orange":
				obj =  new Orange();
				break;
		}
		return obj;
	}
}
