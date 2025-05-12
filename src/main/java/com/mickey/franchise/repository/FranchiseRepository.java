package com.mickey.franchise.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.mickey.franchise.models.model.Franchise;

public interface FranchiseRepository extends ReactiveCrudRepository<Franchise, Long> {
}