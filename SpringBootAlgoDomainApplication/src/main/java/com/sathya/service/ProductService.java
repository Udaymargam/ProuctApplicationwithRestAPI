package com.sathya.service;

import java.util.List;

import com.sathya.entity.Product;

public interface ProductService {
	public Product saveProduct(Product product);
	public Product getoneRecord(int productId);
	public List<Product> getAllRecords();
	public void deleteRecord(int productId);
	public Product updateProduct(Product product,int productIds);
	

}
