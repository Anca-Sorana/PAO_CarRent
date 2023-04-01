package pao.model;

import lombok.Getter;

import java.util.Date;
import java.util.UUID;
@Getter
public class Reservation {
    private UUID id;
    private Integer price;
    private Car car;
    private Date startDate;
    private Date endDate;
}
