package uz.shaftolimarket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.shaftolimarket.service.BasketService;

import java.util.Objects;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/basket")
public class BasketController {

    private final BasketService basketService;
    @PostMapping("/create")
    public ResponseEntity<UUID> createBasket(
            @RequestParam UUID productId,
            @RequestParam Integer count,
            @RequestParam (required = false, defaultValue = "b7bcf6b0-8804-4bde-a82f-0b23980bd297") UUID userId

    ) {
        UUID save;
        if(Objects.equals(userId, UUID.fromString("b7bcf6b0-8804-4bde-a82f-0b23980bd297"))){
            save = basketService.save(productId, count);
        }
        else {
            save  = basketService.save(productId, count, userId);
        }
        System.out.println("save.toString() = " + save.toString());
        return ResponseEntity.ok(save);
    }


}
