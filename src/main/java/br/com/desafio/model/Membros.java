package br.com.desafio.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "membros")
public class Membros implements Serializable {

    @Id
    @Column(name = "idprojeto")
    private Long idprojeto;

    @Column(name = "idpessoa")
    private Long idpessoa;

}
