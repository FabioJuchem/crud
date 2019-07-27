package br.com.fabio.crud.domain;


import java.util.List;

public class Account {

    private String number;

    private String agency;

    private Double balance;

    private Costumer costumer;

    private List<Historic> historic;

    private AccountType accountType;

    public Double getBalance() {
        return balance;
    }

    public List<Historic> getHistoric() {
        return this.historic;
    }

    public void withDraw(Double value){
         this.balance -= value;
         this.historic.add(new Historic(value, OperationType.WITHDRAW));
    }

    public void deposit(Double value){
        this.balance += value;
        this.historic.add(new Historic(value, OperationType.INPUT));
    }

    public void transfer(Double value, Account account){
        this.balance -= value;
        account.balance += value;
        this.historic.add(new Historic(value, OperationType.WITHDRAW));
    }
}
