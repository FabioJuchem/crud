package br.com.fabio.crud.domain;

public enum OperationType {

    INPUT("Entrada"),
    WITHDRAW("Saida");

    private String value;

    OperationType(String value){
        this.value = value;
    }
}
