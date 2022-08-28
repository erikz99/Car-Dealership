package bg.fmi.web.development.car.dealership.controller;

import bg.fmi.web.development.car.dealership.dto.CarDTO;
import bg.fmi.web.development.car.dealership.exception.CarDealershipException;
import bg.fmi.web.development.car.dealership.model.BuyCarRequest;
import bg.fmi.web.development.car.dealership.model.Buyer;
import bg.fmi.web.development.car.dealership.model.CarRequest;
import bg.fmi.web.development.car.dealership.service.impl.CarServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/car-dealership/cars")
public class CarController {

    public static  final String UPLOAD_DIR = "uploads";

    @Autowired
    private CarServiceImpl carService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<CarDTO> getCars() {
        return carService.getCars()
                .stream()
                .map(car -> modelMapper.map(car, CarDTO.class))
                .toList();
    }

    @GetMapping("/brand/{brandName}")
    public List<CarDTO> getCarsByBrandName(@PathVariable String brandName) {
        if (brandName.equals("ALL")) {
            return getCars();
        }
        return carService.getCarsByBrand(brandName)
                .stream()
                .map(car -> modelMapper.map(car, CarDTO.class))
                .toList();
    }

    @GetMapping("/{carId}")
    public CarDTO getCarById(@PathVariable Long carId) {
        return modelMapper.map(carService.getCarById(carId), CarDTO.class);
    }

    @PostMapping(consumes = { "multipart/form-data" })
    public CarDTO createCar(@RequestPart(name = "car") String carRequestString,
                                 @RequestParam(name = "file", required = false) MultipartFile file) throws JsonProcessingException {
        CarRequest carRequest = new ObjectMapper().readValue(carRequestString, CarRequest.class);

        try {
            if (file != null && !file.isEmpty() && file.getOriginalFilename().length() > 0) {
                if (Pattern.matches(".+\\.(jpg|png)", file.getOriginalFilename())) {
                    handleMultipartFile(file);
                    carRequest.setImageUrl("/" + UPLOAD_DIR + "/" + file.getOriginalFilename());
                } else {
                    throw new CarDealershipException("Cannot upload file");
                }
            }
            return modelMapper.map(carService.createCar(carRequest), CarDTO.class);
        } catch (Exception ex) {
            throw new CarDealershipException("Cannot create car");
        }
    }

    @PutMapping(consumes = { "multipart/form-data" })
    public CarDTO updateCar(@RequestPart(name = "car") String carRequestString,
                            @RequestParam(name = "file", required = false) MultipartFile file) throws JsonProcessingException {
        CarDTO carDTO = new ObjectMapper().readValue(carRequestString, CarDTO.class);
        try {
            if (file != null && !file.isEmpty() && file.getOriginalFilename().length() > 0) {
                if (Pattern.matches(".+\\.(jpg|png)", file.getOriginalFilename())) {
                    handleMultipartFile(file);
                    carDTO.setImageUrl("/" + UPLOAD_DIR + "/" + file.getOriginalFilename());
                } else {
                    throw new CarDealershipException("Cannot upload file");
                }
            }
            return modelMapper.map(carService.updateCar(carDTO), CarDTO.class);
        } catch (Exception ex) {
            throw new CarDealershipException("Cannot create car");
        }
    }

    @PatchMapping("/{carId}")
    public CarDTO buyCar(@RequestBody Buyer request,
                            @PathVariable Long carId) {
        log.info("WILL BUY");
        return modelMapper.map(carService.buyCar(request, carId), CarDTO.class);
    }

    @DeleteMapping("/{carId}")
    public void deleteCarById(@PathVariable Long carId) {
        carService.deleteCar(carId);
    }

    private void handleMultipartFile(MultipartFile file) {
        String name = file.getOriginalFilename();
        long size = file.getSize();
        log.info("File: " + name + ", Size: " + size);
        try {
            File currentDir = new File(UPLOAD_DIR);
            if (!currentDir.exists()) {
                currentDir.mkdirs();
            }
            String path = currentDir.getAbsolutePath() + "/" + file.getOriginalFilename();
            path = new File(path).getAbsolutePath();
            log.info(path);
            File f = new File(path);
            FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(f));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
