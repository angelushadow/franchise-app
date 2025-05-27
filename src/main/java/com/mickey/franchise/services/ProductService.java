package com.mickey.franchise.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.mickey.franchise.models.dto.ProductDTO;
import com.mickey.franchise.models.mapper.ProductMapper;
import com.mickey.franchise.models.model.Product;
import com.mickey.franchise.repository.ProductRepository;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductService {	
    
    private ProductRepository productRepository;

    private final ProductMapper mapper = ProductMapper.INSTANCE;

    @PostMapping
    @Operation(summary = "Crear un nuevo producto", description = "Agrega un nuevo producto a una sucursal")
    public Mono<ProductDTO> createProduct(@Valid @RequestBody ProductDTO productDTO) {
        Product product = mapper.toEntity(productDTO);
        return productRepository.save(product).map(mapper::toDTO);
    }

    @PatchMapping("/{productId}/stock")
    @Operation(summary = "Actualizar el stock de un producto", description = "Modifica el stock de un producto específico")
    public Mono<ProductDTO> updateStock(@PathVariable Long productId, @RequestParam int stock) {
        return productRepository.findById(productId)
                .flatMap(product -> {
                    product.setStock(stock);
                    return productRepository.save(product);
                })
                .map(mapper::toDTO);
    }

    @DeleteMapping("/{productId}")
    @Operation(summary = "Eliminar un producto", description = "Elimina un producto específico de una sucursal")
    public Mono<Void> deleteProduct(@PathVariable Long productId) {
        return productRepository.deleteById(productId);
    }

//    @GetMapping("/most-stock")
//    @Operation(summary = "Producto con más stock", description = "Obtiene el producto con más stock por sucursal para una franquicia específica")
//    public Flux<ProductDTO> getProductWithMostStockByFranchise(@RequestParam Long franchiseId) {
//        return productRepository.findAll()
//                .filter(product -> product.getBranch() != null
//                        && product.getBranch().getFranchiseId() != null
//                        && product.getBranch().getFranchiseId().equals(franchiseId))
//                .<Tuple2<Long, Product>>map(product -> Tuples.of(product.getBranch().getId(), product)) // forzar tipos
//                .groupBy(Tuple2::getT1) // agrupar por ID de sucursal (Long)
//                .flatMap(group -> group
//                        .map(Tuple2::getT2)
//                        .sort(Comparator.comparingInt(Product::getStock).reversed())
//                        .next())
//                .map(mapper::toDTO);
//    }


    @PatchMapping("/{productId}/name")
    @Operation(summary = "Actualizar el nombre de un producto", description = "Modifica el nombre de un producto específico")
    public Mono<ProductDTO> updateProductName(@PathVariable Long productId, @RequestParam String name) {
        return productRepository.findById(productId)
                .flatMap(product -> {
                    product.setName(name);
                    return productRepository.save(product);
                })
                .map(mapper::toDTO);
    }

}
