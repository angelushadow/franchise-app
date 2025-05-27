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

import com.mickey.franchise.models.dto.FranchiseDTO;
import com.mickey.franchise.models.mapper.FranchiseMapper;
import com.mickey.franchise.models.model.Franchise;
import com.mickey.franchise.repository.FranchiseRepository;
import com.mickey.franchise.services.FranchiseService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/franchises")
@Tag(name = "Franchise Controller", description = "Gestión de franquicias")
public class FranchiseController {

    @Autowired
    private FranchiseService franchiseService;

    private final FranchiseMapper mapper = FranchiseMapper.INSTANCE;

    @PostMapping
    @Operation(summary = "Crear una nueva franquicia", description = "Agrega una nueva franquicia al sistema")
    public Mono<FranchiseDTO> createFranchise(@Valid @RequestBody FranchiseDTO franchiseDTO) {
      
        return franchiseService.createFranchise(franchiseDTO);
    }

    @GetMapping
    @Operation(summary = "Listar todas las franquicias", description = "Obtiene todas las franquicias disponibles")
    public Flux<FranchiseDTO> getAllFranchises() {
        return franchiseService.getAllFranchises();
    }

    @PatchMapping("/{franchiseId}/name")
    @Operation(summary = "Actualizar el nombre de una franquicia", description = "Actualiza el nombre de una franquicia específica")
    public Mono<FranchiseDTO> updateFranchiseName(@PathVariable Long franchiseId, @RequestParam String name) {
        return franchiseService.updateFranchiseName(franchiseId, name);
 
    }
}