package com.example.rinhabackend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UltimasTransacoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ultimas_transacoes_id")
    private Long id;

    private Integer valor;

    private String tipo;

    private LocalDate realizada_em;
}
