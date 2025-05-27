package com.mickey.franchise.models.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BranchDTO {

    private Long id;

    @NotBlank(message = "El nombre de la sucursal no puede estar vacío")
    @Size(max = 100, message = "El nombre de la sucursal no puede tener más de 100 caracteres")
    private String name;

    @NotNull(message = "El ID de la franquicia no puede ser nulo")
    private Long franchiseId;

    private List<ProductDTO> products;
}