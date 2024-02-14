package com.example.rinhabackend.repositories;

import com.example.rinhabackend.models.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientesRepository extends JpaRepository<Clientes, Long> {


}
