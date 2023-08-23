package uz.shaftolimarket.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "basket")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BasketEntity {
    @Id
    @GeneratedValue
    private UUID id;
    private UUID userId;
    private UUID productId;
    private Integer count;
}
