package pao.service.impl;

import pao.model.Car;
import pao.model.Dealer;
import pao.service.DealerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class DealerServiceImpl implements DealerService {

    private static List<Dealer> dealerList = new ArrayList<>();

    @Override
    public Optional<Dealer> getById(UUID id) {
        return dealerList.stream()
                .filter(elem -> elem.getId().equals(id))
                .findAny();
    }

    @Override
    public void addDealer(Dealer dealer) {
        dealerList.add(dealer);
    }

    @Override
    public void removeDealer(UUID id) {
        dealerList = dealerList.stream()
                .filter(element -> !id.equals(element.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public void modifyDealer(UUID id, Dealer New) {
        removeDealer(id);
        addDealer(New);
    }

    @Override
    public List<Dealer> allDealer() {
        return dealerList;
    }

    @Override
    public void printDealer(Dealer dealer) {
        System.out.print("ID: ");
        System.out.println(dealer.getId());

        System.out.print("First Name: ");
        System.out.println(dealer.getFirst_name());

        System.out.print("Last Name: ");
        System.out.println(dealer.getLast_name());

        System.out.print("Email: ");
        System.out.println(dealer.getEmail());

        System.out.print("Phone Number: ");
        System.out.println(dealer.getPhone_number());

        System.out.println("Dealer's Cars: ");
        if(dealer.getDealerCars().isEmpty())
            System.out.println("Null ");
        else {
            dealer.getDealerCars()
                    .forEach(element -> System.out.println(element.getId()));
        }

        System.out.print("Hire Date: ");
        System.out.println(dealer.getHireDate());

        System.out.print("Salary: ");
        System.out.println(dealer.getSalary());
    }

    @Override
    public void addCar(UUID id, Car car) {
        Optional<Dealer> dealer = getById(id);
        List<Car> cars = dealer.get().getDealerCars();
        cars.add(car);
        for(var elem : dealerList) {
            if(elem.getId() == id) {
                elem.setDealerCars(cars);
            }
        }
    }

    @Override
    public void printList() {
        for(var elem : dealerList) {
            printDealer(elem);
        }
    }
}
