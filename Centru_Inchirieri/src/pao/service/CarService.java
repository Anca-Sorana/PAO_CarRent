package pao.service;

import pao.model.Car;

import java.util.List;
import java.util.UUID;

public interface CarService {
    void addCar(Car car);
    void removeCar(UUID id);
    void modifyCar(UUID id, Car New);
    List<Car> allCars();
}
