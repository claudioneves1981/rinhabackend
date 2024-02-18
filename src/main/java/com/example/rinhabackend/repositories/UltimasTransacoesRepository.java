package com.example.rinhabackend.repositories;

import com.example.rinhabackend.models.UltimasTransacoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UltimasTransacoesRepository extends JpaRepository<UltimasTransacoes, Long> {

}
