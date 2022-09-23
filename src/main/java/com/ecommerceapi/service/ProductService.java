package com.ecommerceapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ecommerceapi.entity.Product;
import com.ecommerceapi.log4j.LogUtilty;
import com.ecommerceapi.log4j.TypeLog;
import com.ecommerceapi.repository.ProductRepository;

@Service
@Transactional
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public Product getProduct(int id) {
		LogUtilty.registrarInfo(getClass(), TypeLog.INFO, "Consulting product:" + id);
		return productRepository.findById(id);
	}

	public List<Product> getProducts() {
		LogUtilty.registrarInfo(this.getClass(), TypeLog.INFO, "Consulting products");
		return (List<Product>) productRepository.findAll();
	}

	public Product addProduct(Product product) {
		LogUtilty.registrarInfo(getClass(), TypeLog.INFO, "Adding product:" + product.getName());
		return productRepository.save(product);
	}

	public Product updateProduct(Product product) {
		try {
			

			Product productOrigin = productRepository.findById(product.getId());

			if (productOrigin != null) {
				LogUtilty.registrarInfo(getClass(), TypeLog.INFO, "Updating product:" + product.getId());
				productOrigin.setName(product.getName());
				productOrigin.setDescription(product.getDescription());
				productOrigin.setPrice(product.getPrice());
				productOrigin.setProvider(product.getProvider());

				return productOrigin;
			}
		} catch (Exception e) {
			LogUtilty.registrarInfo(getClass(), TypeLog.ERROR, "Error updating product:" + e);
		}

		return null;
	}

	public String deleteProduct(int id) {
		try {
			
			Product product = productRepository.findById(id);

			if (product != null) {
				LogUtilty.registrarInfo(getClass(), TypeLog.INFO, "Deleting product:" + id);
				productRepository.deleteById(id);
				return "Producto eliminado correctamente";
			} else {
				return "No se encontró el producto con id:" + id;
			}
		} catch (Exception e) {
			LogUtilty.registrarInfo(getClass(), TypeLog.ERROR, "Error deleting product:" + e);
		} 
		return "Error al borrar producto, intente mas tarde"; 

	}

}
