package pao.model;

import lombok.Getter;

import java.util.UUID;
@Getter
public class Reservation {
    private UUID id;
    private Integer price;
    private Client client;
    private Car car;
}
