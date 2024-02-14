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


    @ManyToOne(cascade=CascadeType.ALL)
    @JoinTable(
            name="TB_CLIENTE_TRANSACOES",
            joinColumns = @JoinColumn(name = "id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id",referencedColumnName = "id")
    )
    private Clientes cliente;
    private Long id;
    private Integer valor;
    private Character tipo;
    private String descricao;

}
