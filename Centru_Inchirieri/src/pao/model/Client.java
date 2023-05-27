package pao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
sealed public class Client extends Person permits PremiumClient {
    private String type; //persoana fizica sau juridica
    private List<Reservation> history;

}
