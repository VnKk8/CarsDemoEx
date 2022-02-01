package com.CarsDemoEx.demo.services;

import com.CarsDemoEx.demo.models.Car;
import com.CarsDemoEx.demo.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarServicesImpl implements CarServices{


    private final CarRepository carRepository;


    @Autowired
    public CarServicesImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Optional<Car> findByPlateNumber(Long plateNumber) {
        return carRepository.findById(plateNumber);
    }

    @Override
    public Page<Car> findAll(Pageable pageable) {
        return carRepository.findAll(pageable);
    }
}
