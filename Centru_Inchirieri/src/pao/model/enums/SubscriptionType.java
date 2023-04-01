package pao.model.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum SubscriptionType {
    BRONZE(3,"Bronze"),
    SILVER(6, "Silver"),
    GOLD(12, "Gold"),
    PLATINUM(24, "Platinum"),
    NONE(0, "None");

    private final String typeString;
    private final Integer months;
    private SubscriptionType(Integer months, String typeString) {
        this.typeString = typeString;
        this.months = months;
    }

    public static SubscriptionType getEnumByFieldString(String field) {
        return Arrays.stream(SubscriptionType.values())
                .filter(enumElement -> enumElement.typeString.equals(field))
                .findAny()
                .orElse(NONE);
    }
}
