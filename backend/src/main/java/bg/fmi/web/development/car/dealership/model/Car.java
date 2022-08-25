package bg.fmi.web.development.car.dealership.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "cars")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Car {

    @Id
    @Column
    @GeneratedValue(strategy = IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

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

    @Embedded
    private Seller seller;

    @Embedded
    private Buyer buyer;

    @Column
    private boolean sold;

    @Column
    @Builder.Default
    private LocalDateTime created = LocalDateTime.now();

    @Column
    @Builder.Default
    private LocalDateTime modified = LocalDateTime.now();
}