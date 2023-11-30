package br.com.desafio.repository;

import br.com.desafio.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Query(value = "SELECT a from pessoa a WHERE a.gerente = true order by a.nome")
    List<Pessoa> listarGerente();
}