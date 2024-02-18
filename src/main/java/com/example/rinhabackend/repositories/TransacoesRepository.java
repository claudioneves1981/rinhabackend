package com.example.rinhabackend.repositories;

import com.example.rinhabackend.models.Transacoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacoesRepository extends JpaRepository<Transacoes, Long> {


    @Query("SELECT t FROM Transacoes t WHERE t.cliente.id = (:id) ORDER BY ID DESC LIMIT 10")
    List<Transacoes> findByTransacoesOrderByDescLimitDez(@Param("id") Long id);

}
