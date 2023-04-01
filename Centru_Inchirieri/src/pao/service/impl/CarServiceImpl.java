package pao.service.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pao.model.Car;
import pao.service.CarService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class CarServiceImpl implements CarService {
    private static List<Car> carList = new ArrayList<>();
    @Override
    public void addCar(Car car) {
        carList.add(car);
    }

    @Override
    public void removeCar(UUID id) {
        carList = carList.stream()
                .filter(element -> !id.equals(element.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public void modifyCar(UUID id, Car New) {
        removeCar(id);
        addCar(New);
    }

    @Override
    public List<Car> allCars() {
        return carList;
    }
}
