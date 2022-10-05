package br.com.mv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mv.entity.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long>{

}
