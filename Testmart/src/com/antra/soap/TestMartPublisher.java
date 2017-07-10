package com.antra.soap;

import javax.xml.ws.Endpoint;

public class TestMartPublisher {

	public static void main(String[] args) {

//		Endpoint.publish("http://localhost:1234/productcatalog", new ProductCatalog());
		Endpoint.publish("http://localhost:5678/productcatalog", new ShopInfo());
		
	}

}
