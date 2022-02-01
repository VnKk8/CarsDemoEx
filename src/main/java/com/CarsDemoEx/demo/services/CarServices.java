package com.CarsDemoEx.demo.services;

import com.CarsDemoEx.demo.models.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CarServices {

    Car addCar(Car car);

    Optional<Car> findByPlateNumber(Long plateNumber);

    Page<Car> findAll(Pageable pageable);
}
