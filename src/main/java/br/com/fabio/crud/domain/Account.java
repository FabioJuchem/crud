package br.com.fabio.crud.domain;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "account")
@ToString
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Account implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    @Column(name = "account_number", unique = true)
    private String accountNumber;

    @Setter
    @Getter
    @Column(name = "agency")
    private String agency;

    @Setter
    @Getter
    @Column(name = "balance")
    private Double balance;

    @Setter
    @Getter
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "costumer_id", referencedColumnName = "id")
    private Costumer costumer;

    @Setter
    @Getter
    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Historic> historic = new ArrayList<Historic>();

    @Setter
    @Getter
    @Enumerated(EnumType.STRING)
    @Column(name = "account_type")
    private AccountType accountType;

    public Double getBalance() {
        return this.balance;
    }

    public List<Historic> getHistoric() {
        return this.historic;
    }

    public void withDraw(Double value){
         this.balance -= value;
         newHistoric(value, OperationType.WITHDRAW);
    }

    public void deposit(Double value){
        this.balance += value;
        newHistoric(value,OperationType.INPUT );
    }

    public void transfer(Double value, Account account){
        this.withDraw(value);
        account.deposit(value);
        newHistoric(value, OperationType.WITHDRAW);
    }

    public void newHistoric(Double value, OperationType operationType){
        this.historic.add(new Historic(value, operationType));
    }
}
