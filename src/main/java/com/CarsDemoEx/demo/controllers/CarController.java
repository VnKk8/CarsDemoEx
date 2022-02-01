package com.CarsDemoEx.demo.controllers;


import com.CarsDemoEx.demo.Dto.CarDto;
import com.CarsDemoEx.demo.models.Car;
import com.CarsDemoEx.demo.services.CarServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarServices carServices;

    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public CarController(CarServices carServices) {
        this.carServices = carServices;
    }


    @PostMapping
    ResponseEntity<CarDto> addCar (@Valid @RequestBody CarDto newCar){
        Car car = modelMapper.map(newCar, Car.class);
        Car createdCar = carServices.addCar(car);
        CarDto mappedDto = modelMapper.map(createdCar, CarDto.class);
        return ResponseEntity.ok(mappedDto);
    }

    @GetMapping("/{plateNumber}")
    ResponseEntity<CarDto> findByPlateNumber (@PathVariable(value = "plateNumber") Long plateNumber){
        Optional<Car> optionalCar = carServices.findByPlateNumber(plateNumber);
        CarDto mappedDto = modelMapper.map(optionalCar.get(), CarDto.class);
        return ResponseEntity.ok(mappedDto);
    }

    @GetMapping
    public Page<Car> findCars(Pageable pageable){
        return carServices.findAll(pageable);
    }

}
