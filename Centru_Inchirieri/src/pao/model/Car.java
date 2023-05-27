package pao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import pao.model.enums.Car_Type;

import java.util.UUID;
@Getter
@AllArgsConstructor
@SuperBuilder
public class Car {
    private UUID id;
    private Car_Type type;
    private String color;
    private Integer year;
    private Integer seatsNumber;
}
