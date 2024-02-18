package com.example.rinhabackend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Extrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "extrato_id")
    private Long id;
    //nomear as colunas

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinTable(
            name="TB_SALDO_EXTRATO",
            joinColumns = @JoinColumn(name = "extrato_id", referencedColumnName = "extrato_id"),
            inverseJoinColumns = @JoinColumn(name = "saldo_id",referencedColumnName = "saldo_id")
    )
    private Saldo saldo;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(
            name="TB_TRANSACOES_EXTRATO",
            joinColumns = @JoinColumn(name = "extrato_id", referencedColumnName = "extrato_id"),
            inverseJoinColumns = @JoinColumn(name = "ultimas_transacoes_id",referencedColumnName = "ultimas_transacoes_id")
    )
    private List<UltimasTransacoes> ultimasTransacoes;
}
