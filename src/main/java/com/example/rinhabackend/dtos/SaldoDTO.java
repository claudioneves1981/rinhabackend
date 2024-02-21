package com.example.rinhabackend.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SaldoDTO {

    private Integer total;

    private LocalDate data_extrato;

    private Integer limite;

}
