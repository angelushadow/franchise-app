package com.mickey.franchise.services;

import org.springframework.stereotype.Service;

import com.mickey.franchise.models.dto.FranchiseDTO;
import com.mickey.franchise.models.mapper.FranchiseMapper;
import com.mickey.franchise.models.model.Franchise;
import com.mickey.franchise.repository.FranchiseRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class FranchiseService {

	private FranchiseRepository franchiseRepository;

	private final FranchiseMapper mapper = FranchiseMapper.INSTANCE;

	public Mono<FranchiseDTO> createFranchise(FranchiseDTO franchiseDTO) {
		Franchise franchise = mapper.toEntity(franchiseDTO);
		return franchiseRepository.save(franchise).map(mapper::toDTO);
	}

	public Flux<FranchiseDTO> getAllFranchises() {
		return franchiseRepository.findAll().map(mapper::toDTO);
	}

	public Mono<FranchiseDTO> updateFranchiseName(Long franchiseId, String name) {
		return franchiseRepository.findById(franchiseId).flatMap(franchise -> {
			franchise.setName(name);
			return franchiseRepository.save(franchise);
		}).map(mapper::toDTO);
	}

}
