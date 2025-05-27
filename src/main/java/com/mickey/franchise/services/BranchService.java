package com.mickey.franchise.services;

import org.springframework.stereotype.Service;

import com.mickey.franchise.models.dto.BranchDTO;
import com.mickey.franchise.models.mapper.BranchMapper;
import com.mickey.franchise.models.model.Branch;
import com.mickey.franchise.repository.BranchRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BranchService {	
	
	private final BranchRepository branchRepository;


	private final BranchMapper mapper = BranchMapper.INSTANCE;

	public Mono<BranchDTO> createBranch(BranchDTO branchDTO) {
		Branch branch = mapper.toEntity(branchDTO);
		return branchRepository.save(branch).map(mapper::toDTO);
	}

	public Mono<BranchDTO> updateBranchName(Long branchId, String name) {
		return branchRepository.findById(branchId).flatMap(branch -> {
			branch.setName(name);
			return branchRepository.save(branch);
		}).map(mapper::toDTO);
	}

	public Flux<BranchDTO> getAllBranches() {
		return branchRepository.findAll().map(mapper::toDTO);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
