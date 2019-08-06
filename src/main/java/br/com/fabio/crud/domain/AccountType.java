package br.com.fabio.crud.domain;

public enum AccountType {

    SAVINGS("Poupança"),
    CHECKING("Corrente");

    private String description;

    AccountType(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
