package pao.service;


import pao.model.PremiumClient;

import java.util.List;
import java.util.UUID;

public interface PremiumClientService {
    void addPremiumClient(PremiumClient premiumClient);
    void removePremiumClient(UUID id);
    void modifyPremiumClient(UUID id, PremiumClient New);
    List<PremiumClient> allPremiumClient();
}
