package pao.model;

import java.util.List;

public final class PremiumClient extends Client{
    private Double discount;

    public PremiumClient(String type, List<Reservation> history) {
        super(type, history);
    }
}
