package com.Rb.Service;

import com.Rb.model.Car;

import java.util.List;


public interface CarService {

    Car insertCar(Car car);

    Car getCarById(int id);

    List getAllCars();

    String deleteCar(int id);

    Car UpdateCar(Car car);




}
