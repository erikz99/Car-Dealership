package bg.fmi.web.development.car.dealership.service.impl;

import bg.fmi.web.development.car.dealership.dto.CarDTO;
import bg.fmi.web.development.car.dealership.exception.EntityNotFoundException;
import bg.fmi.web.development.car.dealership.model.*;
import bg.fmi.web.development.car.dealership.repo.BrandRepository;
import bg.fmi.web.development.car.dealership.repo.CarRepository;
import bg.fmi.web.development.car.dealership.repo.ModelRepository;
import bg.fmi.web.development.car.dealership.service.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepo;

    @Autowired
    private BrandRepository brandRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ModelRepository modelRepository;

    @Override
    public List<Car> getCars() {
        return carRepo.findAll();
    }

    @Override
    public Car getCarById(Long id) {
        return carRepo.findById(id).orElseThrow(() ->
                new EntityNotFoundException(String.format("Car with ID=%s not found.", id)));
    }

    @Override
    public Car createCar(CarRequest carRequest) {
        Model model = modelRepository.findById(carRequest.getModelId())
                .orElseThrow(() -> new EntityNotFoundException("Model doesn't exist"));
        Car car = Car.builder()
                .engine(carRequest.getEngine())
                .sold(false)
                .price(carRequest.getPrice())
                .mileage(carRequest.getMileage())
                .imageUrl(carRequest.getImageUrl())
                .seller(carRequest.getSeller())
                .transmission(carRequest.getTransmission())
                .description(carRequest.getDescription())
                .model(model)
                .year(carRequest.getYear())
                .build();
        return carRepo.save(car);
    }

    @Override
    public Car updateCar(CarDTO carDTO) {
        carDTO.setModified(LocalDateTime.now());
        Car old = getCarById(carDTO.getId());
        if (old == null) {
            throw new EntityNotFoundException(String.format("Car with ID=%s not found.", old.getId()));
        }
        return carRepo.save(modelMapper.map(carDTO, Car.class));
    }

    @Override
    public Car buyCar(Buyer request, Long carId) {
        Car old = getCarById(carId);
        if (old == null) {
            throw new EntityNotFoundException(String.format("Car with ID=%s not found.", old.getId()));
        }
        old.setSold(true);
        old.setBuyer(request);
        return carRepo.save(old);
    }

    @Override
    public void deleteCar(Long id) {
        carRepo.findById(id).orElseThrow(() ->
                new EntityNotFoundException(String.format("Car with ID=%s not found.", id)));
        carRepo.deleteById(id);
    }

}