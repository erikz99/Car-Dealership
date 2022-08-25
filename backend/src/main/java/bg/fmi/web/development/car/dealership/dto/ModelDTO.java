package bg.fmi.web.development.car.dealership.dto;

import bg.fmi.web.development.car.dealership.model.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModelDTO {
    private Long id;
    private String name;
    private Integer startYear;
    private Integer endYear;
}