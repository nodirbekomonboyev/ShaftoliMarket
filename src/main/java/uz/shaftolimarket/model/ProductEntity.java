package uz.shaftolimarket.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductEntity {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    @Column(unique = true)
    private String model;
    private Double price;
    private ProductCategory category;
    private String color;
    private String avatar;
}
