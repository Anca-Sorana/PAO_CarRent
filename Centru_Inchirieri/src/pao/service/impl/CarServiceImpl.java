package pao.service.impl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pao.model.Car;
import pao.service.CarService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class CarServiceImpl implements CarService {
    private static List<Car> carList = new ArrayList<>();

    @Override
    public Optional<Car> getById(UUID id) {
        return carList.stream()
                .filter(elem -> elem.getId().equals(id))
                .findAny();
    }

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

    @Override
    public void printCar(Car car) {
        System.out.print("ID: ");
        System.out.println(car.getId());

        System.out.print("Type: ");
        System.out.println(car.getType());

        System.out.print("Color: ");
        System.out.println(car.getColor());

        System.out.print("Year: ");
        System.out.println(car.getYear());

        System.out.print("Seats Number: ");
        System.out.println(car.getSeatsNumber());
    }

    @Override
    public void printCarList() {
        for(int i = 0; i < carList.size(); i++) {
            printCar(carList.get(i));
        }
        if(carList.size() == 0) {
            System.out.println("No cars left!");
        }
    }
}
