package br.com.mv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mv.entity.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {

}
