package pao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import pao.model.abstracts.Person;

import java.util.List;

@AllArgsConstructor
@SuperBuilder
@Getter
public class Client extends Person {
    private String type; //persoana fizica sau juridica
    private List<Reservation> history;

}
