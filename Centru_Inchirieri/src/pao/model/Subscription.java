package pao.model;

import lombok.Getter;
import pao.model.enums.SubscriptionType;

import java.util.Date;
import java.util.UUID;
@Getter
public class Subscription {
    private UUID id;
    private SubscriptionType type;
    private Integer price;
    private Date startDate;
}
