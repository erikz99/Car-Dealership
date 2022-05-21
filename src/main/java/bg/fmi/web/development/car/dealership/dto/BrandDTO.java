package bg.fmi.web.development.car.dealership.dto;

import bg.fmi.web.development.car.dealership.model.Model;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BrandDTO {
    private Long id;
    private String name;
    private List<Model> models;
    private LocalDateTime created = LocalDateTime.now();
    private LocalDateTime modified = LocalDateTime.now();
}