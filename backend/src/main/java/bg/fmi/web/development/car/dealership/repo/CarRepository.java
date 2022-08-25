package bg.fmi.web.development.car.dealership.repo;

import bg.fmi.web.development.car.dealership.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {

    List<Car> findAll();
}