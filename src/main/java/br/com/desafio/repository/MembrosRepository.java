package br.com.desafio.repository;

import br.com.desafio.model.Membros;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembrosRepository extends JpaRepository<Membros, Long> {

}