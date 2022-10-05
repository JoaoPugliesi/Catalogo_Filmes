package br.com.mv.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mv.dto.FilmeDto;
import br.com.mv.entity.Filme;
import br.com.mv.service.FilmeService;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

	@Autowired
	private FilmeService service;
	
	@PostMapping
	public ResponseEntity<Filme> salvar(@RequestBody FilmeDto dto) {
		Filme filme = new Filme();
		BeanUtils.copyProperties(dto, filme);
		filme.setDataRegistro(LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(filme));
	}
	
	@GetMapping
	public ResponseEntity<List<Filme>> listarTodos() {
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> buscarPorId(@PathVariable Long id) {
		Optional<Filme> filmeOptional = service.findById(id);
		if (!filmeOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Filme não encontrado.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(filmeOptional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletarFilme(@PathVariable Long id) {
		Optional<Filme> filmeOptional = service.findById(id);
		if (!filmeOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Filme não encontrado.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(filmeOptional.get());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> atualizarFilme(@PathVariable Long id, @RequestBody FilmeDto dto ) {
		Optional<Filme> filmeOptional = service.findById(id);
		if (!filmeOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Filme não encontrado.");
		}
		Filme filme = new Filme();
		BeanUtils.copyProperties(dto, filme);
		filme.setId(filmeOptional.get().getId());
		filme.setDataRegistro(filmeOptional.get().getDataRegistro());
		return ResponseEntity.status(HttpStatus.OK).body(service.save(filme));
	}
}
