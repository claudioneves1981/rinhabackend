package com.example.rinhabackend.repositories;

import com.example.rinhabackend.models.Extrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtratoRepository extends JpaRepository<Extrato, Long> {


}
