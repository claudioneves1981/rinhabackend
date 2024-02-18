package com.example.rinhabackend.models.enuns;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Tipo {

    C,
    D;

    @JsonCreator
    public static Tipo fromString(String value) {
        for (Tipo tipo : Tipo.values()) {
            if (tipo.name().equalsIgnoreCase(value)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Especialidade inválida: " + value);
    }
}
