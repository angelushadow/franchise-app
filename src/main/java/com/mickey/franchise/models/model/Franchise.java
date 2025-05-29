package com.mickey.franchise.models.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;
import java.util.List;

@Data
@Table("franchises")
@AllArgsConstructor
@NoArgsConstructor
public class Franchise {
    @Id
    private Long id;
    private String name;
    

}