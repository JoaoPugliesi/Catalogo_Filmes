package br.com.mv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mv.entity.Genero;
import br.com.mv.repository.GeneroRepository;

@Service
public class GeneroService {

	@Autowired
	private GeneroRepository repository;

	public Genero save(Genero genero) {
		return repository.save(genero);
	}

	public List<Genero> findAll() {
		return repository.findAll();
	}

	public Optional<Genero> findById(Long id) {
		return repository.findById(id);
	}

	public void delete(Genero genero) {
		repository.delete(genero);
	}
}
