package pao.service.impl;

import pao.model.PremiumClient;
import pao.service.PremiumClientService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class PremiumClientServiceImpl implements PremiumClientService {

    private static List<PremiumClient> premiumClientList = new ArrayList<>();
    @Override
    public void addPremiumClient(PremiumClient premiumClient) {
        premiumClientList.add(premiumClient);
    }

    @Override
    public void removePremiumClient(UUID id) {
        premiumClientList = premiumClientList.stream()
                .filter(element -> !id.equals(element.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public void modifyPremiumClient(UUID id, PremiumClient New) {
        removePremiumClient(id);
        addPremiumClient(New);
    }

    @Override
    public List<PremiumClient> allPremiumClient() {
        return premiumClientList;
    }
}
