package com.example.rinhabackend.controllers;

import com.example.rinhabackend.dtos.SaldoLimiteDTO;
import com.example.rinhabackend.exceptions.DescricaoMaiorQueDezException;
import com.example.rinhabackend.exceptions.SaldoMenorQueLimiteException;
import com.example.rinhabackend.exceptions.TransacaoMenorQueZeroException;
import com.example.rinhabackend.models.Transacoes;
import com.example.rinhabackend.services.TransacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class TransacoesController {

    @Autowired
    private TransacoesService transacoesService;

    @PostMapping("/clientes/{id}/transacoes")
    public SaldoLimiteDTO transacoes(@RequestBody Transacoes transacoes, @PathVariable("id") Long id) throws TransacaoMenorQueZeroException, DescricaoMaiorQueDezException, SaldoMenorQueLimiteException {
        return transacoesService.createTransacao(transacoes,id);
    }
}
