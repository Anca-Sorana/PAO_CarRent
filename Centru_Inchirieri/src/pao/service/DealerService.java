package pao.service;

import pao.model.Dealer;

import java.util.List;
import java.util.UUID;

public interface DealerService {
    void addDealer(Dealer car);
    void removeDealer(UUID id);
    void modifyDealer(UUID id, Dealer New);
    List<Dealer> allDealer();
}
