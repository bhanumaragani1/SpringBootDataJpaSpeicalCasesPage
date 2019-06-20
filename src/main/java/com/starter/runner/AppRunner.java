package com.starter.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.starter.model.Product;
import com.starter.repository.ProductRepository;

@Component
public class AppRunner implements CommandLineRunner {

	@Autowired
	ProductRepository repo;
	
	@Override
	public void run(String... args) throws Exception {

		Page<Product> page = repo.findByProdCost(7.7,PageRequest.of(0, 3));
		System.out.println(page.isEmpty());
		System.out.println(page.isFirst());
		System.out.println(page.isLast());
		System.out.println(page.hasNext());
		System.out.println(page.hasPrevious());
		System.out.println(page.getSize());
		System.out.println(page.getNumber());
		System.out.println(page.getTotalPages());
		
		page.stream()
		.filter(p->p.getProdCode()!=null)
		.sorted((p1,p2)->p2.getProdId()-p1.getProdId())
		.map(p->p.getProdId()+", "+p.getProdCode()+", "+p.getProdCost())
		.forEach(System.out::println);
	}

}
