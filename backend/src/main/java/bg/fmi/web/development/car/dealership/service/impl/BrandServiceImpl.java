package bg.fmi.web.development.car.dealership.service.impl;

import bg.fmi.web.development.car.dealership.model.Brand;
import bg.fmi.web.development.car.dealership.repo.BrandRepository;
import bg.fmi.web.development.car.dealership.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public List<Brand> getBrands() {
        return brandRepository.findAll();
    }
}
