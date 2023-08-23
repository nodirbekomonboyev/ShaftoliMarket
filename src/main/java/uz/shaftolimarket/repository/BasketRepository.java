package uz.shaftolimarket.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.shaftolimarket.model.BasketEntity;
import java.util.UUID;

@Repository
public interface BasketRepository extends JpaRepository<BasketEntity, UUID> {

}
