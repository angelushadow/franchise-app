package com.mickey.franchise.models.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mickey.franchise.models.dto.FranchiseDTO;
import com.mickey.franchise.models.model.Franchise;

@Mapper
public interface FranchiseMapper {
    FranchiseMapper INSTANCE = Mappers.getMapper(FranchiseMapper.class);

    FranchiseDTO toDTO(Franchise franchise);

    Franchise toEntity(FranchiseDTO franchiseDTO);
}