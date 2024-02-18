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
public class Saldo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="saldo_id")
    private Long id;

    private Integer total;

    private LocalDate data_extrato;

    @Column(name="limite")
    private Integer limite;
}
