package dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDate;

public class PedidoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	public PedidoDTO() {}

	private Long id;

	@NotNull
	private Long idCliente;

	
	@NotNull
	private Long  idCarro;
	
	@NotNull
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate dataInicioEmprestimo;

	@NotNull
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate dataFimEmprestimo;

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

	public Long getIdCarro() {
		return idCarro;
	}

	public void setIdCarro(Long idCarro) {
		this.idCarro = idCarro;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	

}