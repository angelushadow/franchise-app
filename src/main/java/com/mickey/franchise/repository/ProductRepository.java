package com.mickey.franchise.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.mickey.franchise.models.model.Product;

public interface ProductRepository extends ReactiveCrudRepository<Product, Long> {
}