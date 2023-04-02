package pao.model.abstracts;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
@EqualsAndHashCode
public abstract class Person {
    private UUID id;
    private String first_name;
    private String last_name;
    private String email;
    private String phone_number;
}
