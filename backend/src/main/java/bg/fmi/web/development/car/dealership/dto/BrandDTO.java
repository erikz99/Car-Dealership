package bg.fmi.web.development.car.dealership.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BrandDTO {
    private Long id;
    private String name;
    private List<ModelDTO> models;
}