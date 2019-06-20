package com.starter.repository;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.starter.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	Page<Product> findByProdCost(Double pcost, org.springframework.data.domain.Pageable p);

}
