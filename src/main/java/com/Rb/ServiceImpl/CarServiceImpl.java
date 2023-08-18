package com.Rb.ServiceImpl;

import com.Rb.Repository.CarRepository;
import com.Rb.Service.CarService;
import com.Rb.model.Car;
import com.Rb.model.User;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    @Override
    public Car insertCar(Car car){
         return carRepository.save(car);
    }

    @Override
    public Car getCarById(int id) {
        Optional<Car> carOptional= carRepository.findById(id);
        return carOptional.get();
    }

    @Override
    public List getAllCars()
    {
        List<Car> cars=carRepository.findAll();
        List list=new ArrayList<>();
        for ( Car car:cars) {
            var car1= Car.builder()
                    .id(car.getId())
                    .name(car.getName())
                    .price(car.getPrice())
                    .colour(car.getColour())
                    .model(car.getModel())
                    .imageName(car.getImageName())
                    .build();
            list.add(car1);
        }
        return list;
    }

    @Override
    public String deleteCar(int id) {
        Optional<Car> carOptional = carRepository.findById(id);
        if (carOptional.isPresent()) {
            carRepository.delete(carOptional.get());
            return "Car Delete Successfully";
        }
        return "Something went wrong";
    }

    @Override
    public Car UpdateCar(Car car) {
        Car car1=getCarById(car.getId());
        if(car1!=null){
            car1.setName(car.getName());
            car1.setColour(car.getColour());
            car1.setPrice(car.getPrice());
            car1.setModel(car.getModel());
            carRepository.save(car1);
        }
        return car1;
    }


//    @Override
//    public Car getByName(String name) {
//
//        return car;
//    }


}
