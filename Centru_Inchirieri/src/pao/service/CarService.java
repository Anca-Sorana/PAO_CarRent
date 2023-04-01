package pao.service;

import pao.model.Car;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CarService {
    Optional<Car> getById(UUID id);
    void addCar(Car car);
    void removeCar(UUID id);
    void modifyCar(UUID id, Car New);
    List<Car> allCars();
    void printCar(Car car);
}
