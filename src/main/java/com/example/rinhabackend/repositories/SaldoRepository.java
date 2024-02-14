package com.example.rinhabackend.repositories;

import com.example.rinhabackend.models.Saldo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaldoRepository extends JpaRepository<Saldo, Long> {
}
