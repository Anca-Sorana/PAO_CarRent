package pao.service;


import pao.model.RentCenter;

import java.util.List;
import java.util.UUID;

public interface RentCenterService {
    void addRentCenter(RentCenter car);
    void removeRentCenter(UUID id);
    void modifyRentCenter(UUID id, RentCenter New);
    List<RentCenter> allRentCenter();
}
