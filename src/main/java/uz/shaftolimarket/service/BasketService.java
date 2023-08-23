package uz.shaftolimarket.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.shaftolimarket.model.BasketEntity;
import uz.shaftolimarket.model.UserEntity;
import uz.shaftolimarket.model.UserRole;
import uz.shaftolimarket.repository.BasketRepository;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BasketService {

    private final BasketRepository basketRepository;

    public UUID save(UUID productId, Integer count, UUID userId){

        BasketEntity basket = BasketEntity.builder()
                .userId(userId)
                .productId(productId)
                .count(count)
                .build();

        basketRepository.save(basket);

        return userId;
    }
    public UUID save(UUID productId, Integer count){
        UserEntity user = UserEntity.builder()
                .id(UUID.randomUUID())
                .role(UserRole.USER)
                .build();

        BasketEntity basket = BasketEntity.builder()
                .userId(user.getId())
                .productId(productId)
                .count(count)
                .build();

        basketRepository.save(basket);

        return user.getId();
    }


}
