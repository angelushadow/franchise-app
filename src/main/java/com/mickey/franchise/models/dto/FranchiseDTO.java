package com.mickey.franchise.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.util.List;

@Data
public class FranchiseDTO {

    private Long id;

    @NotBlank(message = "El nombre de la franquicia no puede estar vacío")
    @Size(max = 100, message = "El nombre de la franquicia no puede tener más de 100 caracteres")
    private String name;

    private List<BranchDTO> branches;
}