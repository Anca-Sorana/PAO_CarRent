package pao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.UUID;
@Getter
@AllArgsConstructor
@SuperBuilder
public class Reservation {
    private UUID id;
    private Integer price;
    private Car car;
    private LocalDate startDate;
    private LocalDate endDate;
}
