package pao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import pao.model.abstracts.Person;

import java.time.LocalDate;
import java.util.List;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Dealer extends Person {
    private List<Car> dealerCars;
    private LocalDate hireDate;
    private Integer salary;
}
