package pao.model;

import lombok.Getter;
import pao.model.enums.Car_Type;

import java.util.UUID;
@Getter
public class Car {
    private UUID id;
    private Car_Type type;
    private String color;
    private Integer year;
    private Integer seatsNumber;

}
