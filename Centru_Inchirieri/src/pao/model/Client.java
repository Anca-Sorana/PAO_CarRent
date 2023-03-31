package pao.model;

import lombok.Builder;
import lombok.experimental.SuperBuilder;
import pao.model.abstracts.Person;

import java.util.List;

@SuperBuilder
@Builder
public class Client extends Person {
    private String type; //persoana fizica sau juridica
    private List<Reservation> history;


}
