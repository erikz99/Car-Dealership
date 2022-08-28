package bg.fmi.web.development.car.dealership.repo;

import bg.fmi.web.development.car.dealership.model.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {

    List<Car> findAll();

    @Query(value = "SELECT c FROM Car c WHERE c.model IN (SELECT m FROM Model m WHERE m.brand.name=:brandName)")
    List<Car> findByBrand(String brandName);
}