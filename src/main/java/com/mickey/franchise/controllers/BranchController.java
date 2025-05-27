package com.mickey.franchise.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mickey.franchise.models.dto.BranchDTO;
import com.mickey.franchise.models.mapper.BranchMapper;
import com.mickey.franchise.models.model.Branch;
import com.mickey.franchise.repository.BranchRepository;
import com.mickey.franchise.services.BranchService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/branches")
@Tag(name = "Branch Controller", description = "Gestión de sucursales")
@RequiredArgsConstructor
public class BranchController {

	private final BranchService branchService;



	private final BranchMapper mapper = BranchMapper.INSTANCE;

	@PostMapping
	@Operation(summary = "Crear una nueva sucursal", description = "Agrega una nueva sucursal asociada a una franquicia")
	public Mono<BranchDTO> createBranch(@Valid @RequestBody BranchDTO branchDTO) {
		return branchService.createBranch(branchDTO);
	}

	@PatchMapping("/{branchId}")
	@Operation(summary = "Actualizar el nombre de una sucursal", description = "Actualiza el nombre de una sucursal específica")
	public Mono<BranchDTO> updateBranchName(@PathVariable Long branchId, @RequestParam String name) {
		return branchService.updateBranchName(branchId, name);		
	}

	@GetMapping
	@Operation(summary = "Listar todas las sucursales", description = "Obtiene todas las sucursales disponibles")
	public Flux<BranchDTO> getAllBranches() {
		return branchService.getAllBranches();
	}
}