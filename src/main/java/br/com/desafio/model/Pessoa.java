package br.com.desafio.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "datanascimento")
    private Date dataNascimento;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "funcionario")
    private Boolean funcionario;

    @Column(name = "gerente")
    private Boolean gerente;
}
