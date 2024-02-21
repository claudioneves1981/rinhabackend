package com.example.rinhabackend.services;

import com.example.rinhabackend.dtos.ExtratoDTO;
import com.example.rinhabackend.dtos.SaldoDTO;
import com.example.rinhabackend.dtos.UltimasTransacoesDTO;
import com.example.rinhabackend.models.Extrato;
import com.example.rinhabackend.models.Saldo;
import com.example.rinhabackend.models.UltimasTransacoes;
import com.example.rinhabackend.models.*;
import com.example.rinhabackend.repositories.ClientesRepository;
import com.example.rinhabackend.repositories.TransacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExtratoService {

    @Autowired
    private ClientesRepository clientesRepository;

    @Autowired
    private TransacoesRepository transacoesRepository;


    public ExtratoDTO exibeExtrato(Long id){

        Optional<Clientes> clientes = clientesRepository.findById(id);
        List<Transacoes> transacoes = transacoesRepository.findByTransacoesOrderByDescLimitDez(id);
        List<UltimasTransacoesDTO> ultimasTransacoes = new ArrayList<>();
        UltimasTransacoesDTO ultimaTransacao = new UltimasTransacoesDTO();
        ExtratoDTO extrato = new ExtratoDTO();
        SaldoDTO saldo = new SaldoDTO();
        saldo.setTotal(clientes.get().getSaldo());
        saldo.setData_extrato(LocalDate.now());
        saldo.setLimite(clientes.get().getLimite());
        for(Transacoes transacao : transacoes){

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
