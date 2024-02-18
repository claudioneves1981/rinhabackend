package com.example.rinhabackend.services;

import com.example.rinhabackend.dtos.SaldoLimiteDTO;
import com.example.rinhabackend.exceptions.DescricaoMaiorQueDezException;
import com.example.rinhabackend.exceptions.SaldoMenorQueLimiteException;
import com.example.rinhabackend.exceptions.TransacaoMenorQueZeroException;
import com.example.rinhabackend.models.*;
import com.example.rinhabackend.repositories.ClientesRepository;
import com.example.rinhabackend.repositories.ExtratoRepository;
import com.example.rinhabackend.repositories.TransacoesRepository;
import org.hibernate.engine.jdbc.env.spi.ExtractedDatabaseMetaData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransacoesService {

    @Autowired
    private TransacoesRepository transacoesRepository;

    @Autowired
    private ClientesRepository clientesRepository;


    public SaldoLimiteDTO createTransacao(Transacoes transacao, Long id) throws SaldoMenorQueLimiteException, TransacaoMenorQueZeroException, DescricaoMaiorQueDezException {

        Optional<Clientes> cliente = clientesRepository.findById(id);
        Clientes updateCliente = new Clientes();
        Transacoes transacoes = new Transacoes();
        SaldoLimiteDTO saldoLimiteDTO = new SaldoLimiteDTO();

        if(transacao.getValor() < 0){
            throw new TransacaoMenorQueZeroException();
        }

        if (transacao.getDescricao().length() == 0 || transacao.getDescricao().length() > 10){
            throw new DescricaoMaiorQueDezException();
        }

        if(cliente.isPresent() && transacao.getTipo().equals('c')){
            updateCliente.setSaldo_inicial(cliente.get().getSaldo_inicial() + transacao.getValor());
        }else if(cliente.isPresent() && transacao.getTipo().equals('d')){
            updateCliente.setSaldo_inicial(cliente.get().getSaldo_inicial() - transacao.getValor());
            if((Math.abs(updateCliente.getSaldo_inicial() - transacao.getValor()) > cliente.get().getLimite())){
                throw new SaldoMenorQueLimiteException();
            }
        }

         transacoes.setId(transacao.getId());
         transacoes.setTipo(transacao.getTipo());
         transacoes.setValor(transacao.getValor());
         transacoes.setDescricao(transacao.getDescricao());
         transacoesRepository.save(transacoes);

         saldoLimiteDTO.setLimite(updateCliente.getLimite());
         saldoLimiteDTO.setSaldo(updateCliente.getSaldo_inicial());

         return saldoLimiteDTO;
    }



}
