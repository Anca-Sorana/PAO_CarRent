package pao.model;

import lombok.AllArgsConstructor;
import pao.model.abstracts.Person;

import java.util.List;

@AllArgsConstructor
public class Client extends Person {
    private String type; //persoana fizica sau juridica
    private List<Reservation> history;

}
