package pao.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pao.model.Car;

import java.util.Arrays;

@Getter
public enum Car_Type {
    VOLVO("volvo"),
    MERCEDES("mercedes"),
    BMW("bmw"),
    VOLKSWAGEN("volkswagen"),
    AUDI("audi"),
    SKODA("skoda"),
    NONE("none");
    private final String typeString;
    private Car_Type(String typeString) {
        this.typeString = typeString;
    }

    public static Car_Type getEnumByFieldString(String field) {
        return Arrays.stream(Car_Type.values())
                .filter(enumElement -> enumElement.typeString.equals(field))
                .findAny()
                .orElse(NONE);
    }
}
