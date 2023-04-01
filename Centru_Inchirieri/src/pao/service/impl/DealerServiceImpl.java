package pao.service.impl;

import pao.model.Dealer;
import pao.service.DealerService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class DealerServiceImpl implements DealerService {

    private static List<Dealer> dealerList = new ArrayList<>();
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
}
