package br.com.fabio.crud.domain;

public enum AccountType {

    SAVINGS("Poupança"),
    CHECKING("Corrente");

    private String value;

    AccountType(String value){
        this.value = value;
    }
}
