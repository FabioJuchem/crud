package br.com.fabio.crud.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "costumer")
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "cpf")
public class Costumer  implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Setter
    @Getter
    @Column(name = "name")
    private String name;

    @Setter
    @Getter
    @Column(name = "cpf", unique = true)
    private String cpf;

}
