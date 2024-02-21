package com.example.rinhabackend.dtos;

import com.example.rinhabackend.models.Saldo;
import com.example.rinhabackend.models.UltimasTransacoes;
import lombok.Data;

import java.util.List;

@Data
public class ExtratoDTO {

    private SaldoDTO saldo;
    private List<UltimasTransacoesDTO> ultimasTransacoes;

}
