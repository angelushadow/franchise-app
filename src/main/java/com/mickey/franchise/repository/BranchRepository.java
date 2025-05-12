package com.mickey.franchise.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.mickey.franchise.models.model.Branch;

public interface BranchRepository extends ReactiveCrudRepository<Branch, Long> {
}