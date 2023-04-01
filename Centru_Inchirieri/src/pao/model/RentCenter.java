package pao.model;

import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class RentCenter {
    private UUID id;
    private String adress;
    private String name;
    private List<Dealer> employees;
}
