package dto;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;

public class PedidoDTO {

	public PedidoDTO() {}

	private Long id;

	@NotNull
	private ClienteDTO clienteDTO;

	@NotNull
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate dataInicioEmprestimo;

	@NotNull
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate dataFimEmprestimo;

	@NotNull
	private CarroDTO carroDTO;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ClienteDTO getClienteDTO() {
		return clienteDTO;
	}

	public void setClienteDTO(ClienteDTO clienteDTO) {
		this.clienteDTO = clienteDTO;
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

	public CarroDTO getCarroDTO() {
		return carroDTO;
	}

	public void setCarroDTO(CarroDTO carroDTO) {
		this.carroDTO = carroDTO;
	}
}