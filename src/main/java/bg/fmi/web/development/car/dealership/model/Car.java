package bg.fmi.web.development.car.dealership.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Car {

    @Id
    @Column
    @GeneratedValue(strategy = IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column
    @ManyToOne(optional = false)
    private Model model;

    @Column
    private Integer year;

    @Column
    private Integer mileage;

    @Column
    private EngineType engine;

    @Column
    private TransmissionType transmission;

    @Column
    private String description;

    @Column
    private Double price;

    @Column
    private String imageUrl;

    @ManyToOne(optional = true)
    @ToString.Exclude
    private User seller;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Transient
    private Long sellerId;

    @Column
    private LocalDateTime created = LocalDateTime.now();

    @Column
    private LocalDateTime modified = LocalDateTime.now();
}