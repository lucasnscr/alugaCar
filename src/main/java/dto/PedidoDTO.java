package dto;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import enums.Prioridade;

public class PedidoDTO {

	public PedidoDTO() {}

	private Long id;
	
	private Long idCliente;

	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate dataInicioEmprestimo;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate dataFimEmprestimo;

	private Long idCarro;
	
	private Prioridade prioridade;

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

	public Long getIdCarro() {
		return idCarro;
	}

	public void setIdCarro(Long idCarro) {
		this.idCarro = idCarro;
	}
	
	public Prioridade getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}
	
}