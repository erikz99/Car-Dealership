package bg.fmi.web.development.car.dealership.dto;

import bg.fmi.web.development.car.dealership.model.Car;
import bg.fmi.web.development.car.dealership.model.Role;
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
@Table(name = "person")
public class UserDTO {
    private long id;
    private String username;
    private String email;
    private String password;
    private String imageUrl;
    private Role userRole;
    private Collection<Car> cars = new ArrayList<>();
    private LocalDateTime created = LocalDateTime.now();
    private LocalDateTime modified = LocalDateTime.now();
}
