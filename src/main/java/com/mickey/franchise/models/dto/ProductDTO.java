package com.mickey.franchise.models.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductDTO {

    private Long id;

    @NotBlank(message = "El nombre del producto no puede estar vacío")
    private String name;

    @Min(value = 0, message = "El stock no puede ser negativo")
    private int stock;

    @NotNull(message = "El ID de la sucursal no puede ser nulo")
    private Long branchId;
}