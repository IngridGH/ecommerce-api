package com.ecommerceapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerceapi.entity.Product;
import com.ecommerceapi.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductoController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/hola")
	public String hola() {
		return "hola";
	}
	
	@GetMapping("/product/{id}")
	public Product getProduct(@PathVariable("id") int id) {
		
		return productService.getProduct(id);
	}
	
	@GetMapping("/products")
	public List<Product> getProducts(){
		return productService.getProducts();
	}
	
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);	
	}
	
	@PutMapping("/updateProduct")
	public Product updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);	
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable("id") int id) {
		return productService.deleteProduct(id);
	}

}
