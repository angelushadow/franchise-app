package com.mickey.franchise.models.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("products")
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    private Long id;
    private String name;
    private int stock;
    private Long branchId;
}