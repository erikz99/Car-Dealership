package bg.fmi.web.development.car.dealership.dto;

import bg.fmi.web.development.car.dealership.model.EngineType;
import bg.fmi.web.development.car.dealership.model.Model;
import bg.fmi.web.development.car.dealership.model.TransmissionType;
import bg.fmi.web.development.car.dealership.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {
    private Long id;
    private Model model;
    private Integer year;
    private Integer mileage;
    private EngineType engine;
    private TransmissionType transmission;
    private String description;
    private Double price;
    private String imageUrl;
    private User seller;
    private Long sellerId;
    private LocalDateTime created = LocalDateTime.now();
    private LocalDateTime modified = LocalDateTime.now();
}