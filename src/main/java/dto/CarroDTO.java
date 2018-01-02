package dto;

import enums.FlagAtivo;

import java.io.Serializable;
import java.time.LocalDate;

public class CarroDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private Long idCliente;

	private Long idPedido;

	private LocalDate dataInicioEmprestimo;

	private LocalDate dataFimEmprestimo;

	private String placa;

	private String tipo;

	private Long kilometragem;

	private Long kilometragemFinal;

	private FlagAtivo ativo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public LocalDate getDataInicioEmprestimo() {
		return dataInicioEmprestimo;
	}

	public void setDataInicioEmprestimo(LocalDate dataInicioEmprestimo) {
		this.dataInicioEmprestimo = dataInicioEmprestimo;
	}

	public LocalDate getDataFimEmprestimo() {
		return dataFimEmprestimo;
	}

	public void setDataFimEmprestimo(LocalDate dataFimEmprestimo) {
		this.dataFimEmprestimo = dataFimEmprestimo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Long getKilometragem() {
		return kilometragem;
	}

	public void setKilometragem(Long kilometragem) {
		this.kilometragem = kilometragem;
	}

	public Long getKilometragemFinal() {
		return kilometragemFinal;
	}

	public void setKilometragemFinal(Long kilometragemFinal) {
		this.kilometragemFinal = kilometragemFinal;
	}

	public FlagAtivo getAtivo() {
		return ativo;
	}

	public void setAtivo(FlagAtivo ativo) {
		this.ativo = ativo;
	}
}
