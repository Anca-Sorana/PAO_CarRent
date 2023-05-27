package pao.repository;

import pao.model.Car;
import pao.model.Client;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CarRepository {
    Optional<Car> getObjectById(UUID id);

    void deleteObjectById(UUID id);

    void updateObjectById(UUID id, Car newObject);

    void addNewObject(Car carClass);

    List<Car> getAll();

    void addAllFromGivenList(List<Car> carList);
}
