package br.com.desafio.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "projeto")
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "data_inicio")
    private Date dataInicio;

    @Column(name = "data_previsao_fim")
    private Date dataPrevisaoFim;

    @Column(name = "data_fim")
    private Date dataFim;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "risco")
    private String risco;

    @Column(name = "status")
    private String status;

    @Column(name = "orcamento")
    private Double orcamento;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idgerente", referencedColumnName = "id")
    private Pessoa pessoa;

}
