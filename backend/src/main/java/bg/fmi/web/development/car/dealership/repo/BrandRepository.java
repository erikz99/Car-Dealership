package bg.fmi.web.development.car.dealership.repo;

import bg.fmi.web.development.car.dealership.model.Brand;
import bg.fmi.web.development.car.dealership.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends CrudRepository<Brand, Long> {

    List<Brand> findAll();
}