package com.ecommerceapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ecommerceapi.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, String> {

	Product findById(int id);
	void deleteById(int id);
}
