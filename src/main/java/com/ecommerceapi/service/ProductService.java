package com.ecommerceapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ecommerceapi.entity.Product;
import com.ecommerceapi.repository.ProductRepository;

@Service
@Transactional
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public Product getProduct(int id) {
		return productRepository.findById(id);
	}

	public List<Product> getProducts() {
		return (List<Product>) productRepository.findAll();
	}

	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	public Product updateProduct(Product product) {
		Product productOrigin = productRepository.findById(product.getId());

		if (productOrigin != null) {
			productOrigin.setName(product.getName());
			productOrigin.setDescription(product.getDescription());
			productOrigin.setPrice(product.getPrice());
			productOrigin.setProvider(product.getProvider());
			return productOrigin;
		} else {
			return null;
		}
	}

	public String deleteProduct(int id) {
		Product product = productRepository.findById(id);

		if (product != null) {
			productRepository.deleteById(id);
			return "Producto eliminado correctamente";
		} else {
			return "No se encontró el producto con id:" + id;
		}
	}

}
