package bg.fmi.web.development.car.dealership.dto;

import bg.fmi.web.development.car.dealership.model.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {
    private Long id;
    private ModelDTO model;
    private Integer year;
    private Integer mileage;
    private EngineType engine;
    private TransmissionType transmission;
    private String description;
    private Double price;
    private String imageUrl;
    private Seller seller;
    private Buyer buyer;
    private boolean sold;
    private LocalDateTime created;
    private LocalDateTime modified;
}