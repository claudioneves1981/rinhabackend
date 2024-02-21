package com.example.rinhabackend.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UltimasTransacoesDTO {

    private Integer valor;

    private String tipo;

    private LocalDate realizada_em;

}
