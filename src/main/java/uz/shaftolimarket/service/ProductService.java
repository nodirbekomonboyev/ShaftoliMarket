package uz.shaftolimarket.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.shaftolimarket.exception.DataNotFound;
import uz.shaftolimarket.exception.WrongInformationException;
import uz.shaftolimarket.model.ProductCategory;
import uz.shaftolimarket.model.ProductEntity;
import uz.shaftolimarket.model.UserEntity;
import uz.shaftolimarket.model.UserRole;
import uz.shaftolimarket.repository.ProductRepository;
import uz.shaftolimarket.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static uz.shaftolimarket.model.ProductCategory.*;
import static uz.shaftolimarket.model.UserRole.ADMIN;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    public ProductEntity save(ProductEntity product, UUID userId) {
        Optional<UserEntity> byId = userRepository.findById(userId);
        if(byId.isEmpty()) {
            throw new DataNotFound("user not found");
        }
        if(byId.get().getRole().equals(ADMIN)) {
            product.setId(UUID.randomUUID());
            return productRepository.save(product);
        } else {
            throw new WrongInformationException("User roli xato");
        }
    }
    public List<ProductEntity> findByCategory (String category) {
        List<ProductEntity> productEntities = new ArrayList<>();
        System.out.println("category = " + category);
        switch (category) {
            case "SABZAVOT" -> {
                productEntities = productRepository.findByCategory(SABZAVOT);
            }
            case "MEVA" -> {
                productEntities = productRepository.findByCategory(MEVA);
            }
            case "KIYIM_KECHAK" -> {
                productEntities = productRepository.findByCategory(KIYIM_KECHAK);
            }
            case "TEXNIKA" -> {
                productEntities = productRepository.findByCategory(TEXNIKA);
            }
            case "AVTOMOBIL" -> {
                productEntities = productRepository.findByCategory(AVTOMOBIL);
            }
        }
        return productEntities;
    }

    public void update(UUID productId, Double newPrice) {
        Optional<ProductEntity> byId = productRepository.findById(productId);
        if(byId.isEmpty()) {
            throw new DataNotFound("product not found");
        }
        byId.get().setPrice(newPrice);
        productRepository.save(byId.get());
    }

    public void delete(UUID productId) {
        productRepository.deleteById(productId);
    }
}
