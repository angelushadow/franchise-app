package com.mickey.franchise.models.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mickey.franchise.models.dto.BranchDTO;
import com.mickey.franchise.models.model.Branch;

@Mapper
public interface BranchMapper {
    BranchMapper INSTANCE = Mappers.getMapper(BranchMapper.class);

    BranchDTO toDTO(Branch branch);

    Branch toEntity(BranchDTO branchDTO);
}