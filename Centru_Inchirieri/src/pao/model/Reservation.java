package pao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;
@Getter
@AllArgsConstructor
public class Reservation {
    private UUID id;
    private Integer price;
    private Car car;
    private LocalDate startDate;
    private LocalDate endDate;
}
