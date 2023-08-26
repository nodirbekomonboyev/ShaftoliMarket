package uz.shaftolimarket.model;


import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "email_code")
@Table(name = "email_code")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EmailCodeEntity{
    @Id
    @GeneratedValue
    private UUID id;
    @Column(unique = true)
    private String email;
    private String code;
    @Timestamp
    private LocalDateTime limits;
}
