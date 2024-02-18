package com.example.rinhabackend.repositories;

import com.example.rinhabackend.models.Saldo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaldoRepository extends JpaRepository<Saldo, Long> {
}
