package bg.fmi.web.development.car.dealership.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    private String imageUrl;

    @OneToMany(mappedBy = "seller")
    @ToString.Exclude
    @JsonIgnore
    private Collection<Car> cars = new ArrayList<>();

    @Column
    private LocalDateTime created = LocalDateTime.now();

    @Column
    private LocalDateTime modified = LocalDateTime.now();

    @Column
    @Enumerated(EnumType.STRING)
    private Role userRole;

    @Column
    private boolean active = true;

    @Column(nullable = false)
    @Builder.Default
    private boolean locked = false;

    @Column(nullable = false)
    @Builder.Default
    private boolean enabled = true;
}
