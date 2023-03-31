package pao.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum Car_Type {
    VOLVO("Volvo"),
    MERCEDES("Mercedes"),
    BMW("BMW"),
    VOLKSWAGEN("Volkswagen"),
    AUDI("Audi"),
    SKODA("Skoda"),
    NONE("None");
    private final String typeString;

    public static Car_Type getEnumByFieldString(String field) {
        return Arrays.stream(Car_Type.values())
                .filter(enumElement -> enumElement.typeString.equals(field))
                .findAny()
                .orElse(NONE);
    }
}
