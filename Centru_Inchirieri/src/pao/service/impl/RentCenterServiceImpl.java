package pao.service.impl;

import pao.model.RentCenter;
import pao.service.RentCenterService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class RentCenterServiceImpl implements RentCenterService {
    private static List<RentCenter> rentCenterList = new ArrayList<>();
    @Override
    public void addRentCenter(RentCenter rentCenter) {
        rentCenterList.add(rentCenter);
    }

    @Override
    public void removeRentCenter(UUID id) {
        rentCenterList = rentCenterList.stream()
                .filter(element -> !id.equals(element.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public void modifyRentCenter(UUID id, RentCenter New) {
        removeRentCenter(id);
        addRentCenter(New);
    }

    @Override
    public List<RentCenter> allRentCenter() {
        return rentCenterList;
    }
}
