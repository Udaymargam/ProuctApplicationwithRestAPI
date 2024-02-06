package com.sathya.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sathya.entity.Product;
import com.sathya.service.ProductServiceImp;

@RestController
public class ProductController {
	@Autowired
	private ProductServiceImp service;
	
	
	@PostMapping("/save")
	public String saveProduct(@RequestBody Product product)
	{
		Product p=service.saveProduct(product);
		return "Data inserted successfully";
		
	}
	@GetMapping("/getone/{productId}")
	public Product getProduct(@PathVariable int productId)
	{
		Product p=service.getoneRecord(productId);
		return p;
	}
	@GetMapping("/getall")
	public List<Product> getAll() {
	    List<Product> productList = service.getAllRecords();
	    return productList;
	}
	@DeleteMapping("/delete/{productId}")
	public String delete(@PathVariable int productId)
	{
		service.deleteRecord(productId);
		return "data deleted successfully";
	}
    @PutMapping("/update/{productId}")
    public Product update(@RequestBody Product product,@PathVariable int productId)
    {
    	Product p=service.updateProduct(product, productId);
    	return p;
    }

}
