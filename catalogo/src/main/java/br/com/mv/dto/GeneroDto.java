package br.com.mv.dto;

import br.com.mv.entity.Genero;

public class GeneroDto {

	private Long id;
	private String nome;

	public GeneroDto() {

	}

	public GeneroDto(String nome) {
		super();
		this.nome = nome;
	}

	public GeneroDto(Genero entity) {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}