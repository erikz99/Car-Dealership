package bg.fmi.web.development.car.dealership.service;

import bg.fmi.web.development.car.dealership.dto.CarDTO;
import bg.fmi.web.development.car.dealership.model.BuyCarRequest;
import bg.fmi.web.development.car.dealership.model.Buyer;
import bg.fmi.web.development.car.dealership.model.Car;
import bg.fmi.web.development.car.dealership.model.CarRequest;

import java.util.List;

public interface CarService {

    List<Car> getCars();

    Car getCarById(Long id);

    Car createCar(CarRequest carRequest);

    Car updateCar(CarDTO car);

     Car buyCar(Buyer request, Long carId);

    void deleteCar(Long id);
}
