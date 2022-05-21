package bg.fmi.web.development.car.dealership.repo;

import bg.fmi.web.development.car.dealership.model.Brand;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends CrudRepository<Brand, Long> {
}