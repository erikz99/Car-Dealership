package bg.fmi.web.development.car.dealership;

import bg.fmi.web.development.car.dealership.model.Brand;
import bg.fmi.web.development.car.dealership.model.Model;
import bg.fmi.web.development.car.dealership.repo.BrandRepository;
import bg.fmi.web.development.car.dealership.repo.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Initializer implements CommandLineRunner {

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ModelRepository modelRepository;

    @Override
    public void run(String...args) throws Exception {
        Brand audi = Brand.builder()
                .name("Audi")
                .models(new ArrayList<>())
                .build();

        audi = brandRepository.save(audi);

        Model modelA3 = Model.builder()
                .name("Audi A3")
                .brand(audi)
                .startYear(1998)
                .endYear(2022)
                .build();

        modelA3 = modelRepository.save(modelA3);
        audi.getModels().add(modelA3);

        Model modelA4 = Model.builder()
                .name("Audi A4")
                .brand(audi)
                .startYear(1996)
                .endYear(2022)
                .build();

        modelA4 = modelRepository.save(modelA4);
        audi.getModels().add(modelA4);

        Model modelA6 = Model.builder()
                .name("Audi A6")
                .brand(audi)
                .startYear(1996)
                .endYear(2022)
                .build();

        modelA6 = modelRepository.save(modelA6);
        audi.getModels().add(modelA6);
        brandRepository.save(audi);

        Brand mercedes = Brand.builder()
                .name("Mercedes")
                .models(new ArrayList<>())
                .build();

        mercedes = brandRepository.save(mercedes);

        Model modelML = Model.builder()
                .name("Mercedes ML")
                .brand(mercedes)
                .startYear(2007)
                .endYear(2022)
                .build();

        modelML = modelRepository.save(modelML);
        mercedes.getModels().add(modelML);

        Model modelCLS = Model.builder()
                .name("Mercedes CLS")
                .brand(mercedes)
                .startYear(2012)
                .endYear(2022)
                .build();

        modelCLS = modelRepository.save(modelCLS);
        mercedes.getModels().add(modelCLS);

        brandRepository.save(mercedes);

        Brand bmw = Brand.builder()
                .name("BMW")
                .models(new ArrayList<>())
                .build();

        bmw = brandRepository.save(bmw);

        Model modelE92 = Model.builder()
                .name("BMW E92")
                .brand(bmw)
                .startYear(1998)
                .endYear(2022)
                .build();

        modelE92 = modelRepository.save(modelE92);
        bmw.getModels().add(modelE92);

        brandRepository.save(bmw);
    }
}