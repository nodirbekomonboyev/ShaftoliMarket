package uz.shaftolimarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.shaftolimarket.model.EmailCodeEntity;
import java.util.UUID;

@Repository
public interface EmailCodeRepository extends JpaRepository<EmailCodeEntity, UUID> {

}
