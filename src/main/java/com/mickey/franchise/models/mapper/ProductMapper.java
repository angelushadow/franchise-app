package com.mickey.franchise.models.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mickey.franchise.models.dto.ProductDTO;
import com.mickey.franchise.models.model.Product;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDTO toDTO(Product product);
    List<ProductDTO> toDTO(List<Product> products);

    Product toEntity(ProductDTO productDTO);
}