package com.antra.soap;

import java.util.List;

import javax.jws.WebService;

import com.antra.soap.business.ProductServiceImpl;
import com.antra.soap.model.Product;

import javax.jws.WebMethod;

@WebService(portName="TestMartCatalogPort", serviceName="TestMartCatalogService", endpointInterface="com.antra.soap.ProductCatalogInterface")
public class ProductCatalog implements ProductCatalogInterface {
	
	ProductServiceImpl productService = new ProductServiceImpl();
	// happens only once
	// it's the same instance of ProductCatalog which it's used for every call

	@Override
	public List<String> getProductCategories() {
		return productService.getProductCategories();
	}
	
	@Override
	public List<String> getProducts(String category) {
		return productService.getProducts(category);
	}
	
	@Override
	public boolean addProduct(String category, String product) {
		return productService.addProduct(category, product);
	}
	
	@Override
	public List<Product> getProductsv2(String category) {
		return productService.getProductsv2(category);
	}
}
