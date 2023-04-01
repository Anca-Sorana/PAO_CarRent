package pao.model;

import lombok.Builder;
import pao.model.abstracts.Person;

import java.util.List;

@Builder
public class Dealer extends Person {
    private List<Car> dealerCars;
    private String hireDate;
    private Integer salary;
}
