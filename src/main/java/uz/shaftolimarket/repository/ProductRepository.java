package uz.shaftolimarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.shaftolimarket.model.ProductCategory;
import uz.shaftolimarket.model.ProductEntity;
import uz.shaftolimarket.model.UserEntity;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {
    List<ProductEntity> findByCategory(ProductCategory category);

}
