package pao.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import pao.model.Client;
import pao.model.Dealer;

import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
@EqualsAndHashCode
sealed public abstract class Person permits Client, Dealer {
    private UUID id;
    private String first_name;
    private String last_name;
    private String email;
    private String phone_number;
}
