package pao.model;

import lombok.Getter;
import pao.model.enums.SubscriptionType;

import java.util.UUID;
@Getter
public class Subscription {
    private UUID id;
    private SubscriptionType type;
    private Integer price;
    private String startDate;
}
