package com.mickey.franchise.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mickey.franchise.models.dto.ProductDTO;
import com.mickey.franchise.models.mapper.ProductMapper;
import com.mickey.franchise.models.model.Product;
import com.mickey.franchise.repository.ProductRepository;
import com.mickey.franchise.services.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Product Controller", description = "Gestión de productos")
@RequiredArgsConstructor
public class ProductController {

    private ProductService productService;

    private final ProductMapper mapper = ProductMapper.INSTANCE;

    @PostMapping
    @Operation(summary = "Crear un nuevo producto", description = "Agrega un nuevo producto a una sucursal")
    public Mono<ProductDTO> createProduct(@Valid @RequestBody ProductDTO productDTO) {
        return productService.createProduct(productDTO);
    }

    @PatchMapping("/{productId}/stock")
    @Operation(summary = "Actualizar el stock de un producto", description = "Modifica el stock de un producto específico")
    public Mono<ProductDTO> updateStock(@PathVariable Long productId, @RequestParam int stock) {
        return productService.updateStock(productId, stock);
    }

    @DeleteMapping("/{productId}")
    @Operation(summary = "Eliminar un producto", description = "Elimina un producto específico de una sucursal")
    public Mono<Void> deleteProduct(@PathVariable Long productId) {
        return productService.deleteProduct(productId);
    }

	/*
	 * @GetMapping("/most-stock")
	 * 
	 * @Operation(summary = "Producto con más stock", description =
	 * "Obtiene el producto con más stock por sucursal para una franquicia específica"
	 * ) public Flux<ProductDTO> getProductWithMostStockByFranchise(@RequestParam
	 * Long franchiseId) { return
	 * productService.getProductWithMostStockByFranchise(franchiseId); }
	 */


    @PatchMapping("/{productId}/name")
    @Operation(summary = "Actualizar el nombre de un producto", description = "Modifica el nombre de un producto específico")
    public Mono<ProductDTO> updateProductName(@PathVariable Long productId, @RequestParam String name) {
        return productService.updateProductName(productId, name);
    }
}