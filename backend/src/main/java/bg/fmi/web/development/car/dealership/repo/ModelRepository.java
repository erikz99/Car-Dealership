package bg.fmi.web.development.car.dealership.repo;

import bg.fmi.web.development.car.dealership.model.Model;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends CrudRepository<Model, Long> {
}