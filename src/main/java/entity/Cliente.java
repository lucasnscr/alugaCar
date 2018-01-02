package main.java.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import main.java.enums.FlagAtivo;

import java.time.LocalDateTime;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@NotNull
	private String name;

	@NotNull
	private String tipo;

	private FlagAtivo ativo;

	private LocalDateTime atualizacao;
	
	public FlagAtivo getAtivo() {
		return ativo;
	}

	public void setAtivo(FlagAtivo ativo) {
		this.ativo = ativo;
	}

	public LocalDateTime getAtualizacao() {
		return atualizacao;
	}

	public void setAtualizacao(LocalDateTime atualizacao) {
		this.atualizacao = atualizacao;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

}
