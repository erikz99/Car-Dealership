package bg.fmi.web.development.car.dealership.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Model {

    @Id
    @Column
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Integer startYear;

    @Column
    private Integer endYear;

    @ManyToOne
    private Brand brand;

    @Column
    private String imageUrl;

    @Column
    private LocalDateTime created = LocalDateTime.now();

    @Column
    private LocalDateTime modified = LocalDateTime.now();

}