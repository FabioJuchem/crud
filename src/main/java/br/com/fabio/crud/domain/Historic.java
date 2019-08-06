package br.com.fabio.crud.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "historic")
@NoArgsConstructor
@ToString
@Getter
@EqualsAndHashCode(of = "id")
public class Historic implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(name = "date")
    private LocalDateTime date = LocalDateTime.now();

    @Getter
    @Setter
    @Column(name = "value")
    private Double value;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "operation_Type")
    private OperationType operationType;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;


    public Historic(Double value, OperationType operationType) {
        this.value = value;
        this.operationType = operationType;
    }
}
