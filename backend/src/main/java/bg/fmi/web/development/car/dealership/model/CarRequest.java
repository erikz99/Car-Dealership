package bg.fmi.web.development.car.dealership.model;

import bg.fmi.web.development.car.dealership.dto.ModelDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarRequest {
    private Long modelId;
    private Integer year;
    private Integer mileage;
    private EngineType engine;
    private TransmissionType transmission;
    private String description;
    private Double price;
    private String imageUrl;
    private Seller seller;
    private Buyer buyer;
}
