package uz.shaftolimarket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.shaftolimarket.model.ProductEntity;
import uz.shaftolimarket.service.ProductService;

import java.util.List;
import java.util.UUID;


@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    @PostMapping("/create/{userId}")
    public ResponseEntity<ProductEntity> createProduct(
            @RequestBody ProductEntity product,
            @PathVariable UUID userId
            ) {
        return ResponseEntity.ok(productService.save(product, userId));
    }

    @GetMapping("/find-by-category")
    public ResponseEntity<List<ProductEntity>> createProduct(
            @RequestParam String category
    ) {
        return ResponseEntity.ok(productService.findByCategory(category));
    }
    @PutMapping("/update/{productId}")
    public ResponseEntity<String> updateProduct(
            @PathVariable UUID productId,
            @RequestParam Double price
    ) {
        productService.update(productId, price);
        return ResponseEntity.status(HttpStatus.valueOf(204)).build();
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<String> deleteProduct(
            @PathVariable UUID productId
    ) {
        productService.delete(productId);
        return ResponseEntity.status(HttpStatus.valueOf(204)).build();
    }

}
