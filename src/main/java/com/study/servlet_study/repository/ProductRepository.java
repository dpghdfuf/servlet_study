package com.study.servlet_study.repository;

import java.util.ArrayList;
import java.util.List;

import com.study.servlet_study.entity.Product;

public class ProductRepository {
	private List<Product> productList;
	private static ProductRepository instance;
	
	
	
	private ProductRepository() {
		productList = new ArrayList<>();
	}
	public static ProductRepository getInstance() {
		if(instance == null) {
			instance = new ProductRepository();
		}
		
		return instance;
	}
	
	public boolean isDuplicatonProduct(String ProductName) {
	for(Product product : productList){
		if(product.getProductName().equals(ProductName)) {
			return true;
		}
	}
	return false;
	}
	public Product findProductbyproductName(String productName) {
		Product findProduct = null;
		
		for(Product product : productList) {
			if(product.getProductName().equals(productName)) {
				findProduct = product;
				break;
			}
		}
		return findProduct;
	}
	
	
	
	
}
/* 
 * 
 */

