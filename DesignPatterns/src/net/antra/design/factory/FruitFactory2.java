package net.antra.design.factory;

import java.util.HashMap;
import java.util.Map;

public class FruitFactory2 {
	
	Map<String,Object> fruitMap = new HashMap<>();
	
	public FruitFactory2(){
		fruitMap.put("apple", new Apple());
		fruitMap.put("orange", new Orange());
	}
	
	public Object createFruit(String name){
		return fruitMap.get(name);
	}
}
