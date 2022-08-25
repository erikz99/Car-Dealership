package bg.fmi.web.development.car.dealership.controller;

import bg.fmi.web.development.car.dealership.dto.BrandDTO;
import bg.fmi.web.development.car.dealership.service.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/car-dealership/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<BrandDTO> getBrands() {
        return brandService.getBrands()
                .stream()
                .map(brand -> modelMapper.map(brand, BrandDTO.class))
                .toList();
    }

}
