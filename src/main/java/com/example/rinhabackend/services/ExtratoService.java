package com.example.rinhabackend.services;

import com.example.rinhabackend.models.*;
import com.example.rinhabackend.repositories.ClientesRepository;
import com.example.rinhabackend.repositories.ExtratoRepository;
import com.example.rinhabackend.repositories.TransacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ExtratoService {

    @Autowired
    private ClientesRepository clientesRepository;

    @Autowired
    private ExtratoRepository extratoRepository;

    @Autowired
    private TransacoesRepository transacoesRepository;


    public Extrato exibeExtrato(Long id){

        Optional<Clientes> clientes = clientesRepository.findById(id);
        List<Transacoes> transacoes = transacoesRepository.findByTransacoesOrderByDescLimitDez(id);
        List<UltimasTransacoes> ultimasTransacoes = new ArrayList<>();
        UltimasTransacoes ultimaTransacao = new UltimasTransacoes();
        Extrato extrato = new Extrato();
        Saldo saldo = new Saldo();
        saldo.setTotal(clientes.get().getSaldo_inicial());
        saldo.setData_extrato(LocalDate.now());
        saldo.setLimite(clientes.get().getLimite());
        for(Transacoes transacao : transacoes){

            ultimaTransacao.setId(transacao.getId());
            ultimaTransacao.setTipo(transacao.getTipo());
            ultimaTransacao.setValor(transacao.getValor());
            ultimaTransacao.setRealizada_em(LocalDate.now());
            ultimasTransacoes.add(ultimaTransacao);

        }

        extrato.setSaldo(saldo);
        extrato.setUltimasTransacoes(ultimasTransacoes);

        return extrato;

    }
}
