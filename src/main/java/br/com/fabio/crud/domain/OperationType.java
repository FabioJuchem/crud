package br.com.fabio.crud.domain;

public enum OperationType {

    INPUT("Entrada"),
    WITHDRAW("Saida");

    private String description;

    OperationType(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
