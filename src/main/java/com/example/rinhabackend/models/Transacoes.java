package com.example.rinhabackend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transacoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="transacoes_id")
    private Long id;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinTable(
            name="TB_CLIENTE_TRANSACOES",
            joinColumns = @JoinColumn(name = "transacoes_id", referencedColumnName = "transacoes_id"),
            inverseJoinColumns = @JoinColumn(name = "cliente_id",referencedColumnName = "cliente_id")
    )
    private Clientes cliente;

    private Integer valor;

    private String tipo;

    private String descricao;

}
