package com.mickey.franchise.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.mickey.franchise.models.model.Branch;

@Repository
public interface BranchRepository extends ReactiveCrudRepository<Branch, Long> {
}