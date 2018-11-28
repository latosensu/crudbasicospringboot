package br.ufscar.latosensu.crudbasico.entidade;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "pessoa")
@Data
public class Pessoa {

    public Pessoa(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false, unique = true)
    private Integer idade;
}
