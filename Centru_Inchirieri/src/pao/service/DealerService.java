package pao.service;

import pao.model.Car;
import pao.model.Dealer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DealerService {
    Optional<Dealer> getById(UUID id);
    void addDealer(Dealer dealer);
    void removeDealer(UUID id);
    void modifyDealer(UUID id, Dealer New);
    List<Dealer> allDealer();
    void printDealer(Dealer dealer);
    void addCar(UUID id, Car car);
    void printDealerById(UUID id);

}
