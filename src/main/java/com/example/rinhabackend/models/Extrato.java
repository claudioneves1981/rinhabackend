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
    private Long id;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinTable(
            name="TB_SALDO_EXTRATO",
            joinColumns = @JoinColumn(name = "id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id",referencedColumnName = "id")
    )
    private Saldo saldo;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(
            name="TB_TRANSACOES_EXTRATO",
            joinColumns = @JoinColumn(name = "id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id",referencedColumnName = "id")
    )
    private List<UltimasTransacoes> ultimasTransacoes;
}
