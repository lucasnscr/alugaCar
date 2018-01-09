package entity;

import enums.FlagAtivo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection="pedido")
@Entity
public class Pedido {

	@Indexed(unique=true)
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private Long idCliente;

	@NotNull
	private Long idCarro;

	@NotNull
	private LocalDate dataEmprestimo;
	
	@NotNull
	private FlagAtivo ativo;

	private Long idPedidoAtualizado;

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

	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public FlagAtivo getAtivo() {
		return ativo;
	}

	public void setAtivo(FlagAtivo ativo) {
		this.ativo = ativo;
	}

	public Long getIdPedidoAtualizado() {
		return idPedidoAtualizado;
	}

	public void setIdPedidoAtualizado(Long idPedidoAtualizado) {
		this.idPedidoAtualizado = idPedidoAtualizado;
	}
	
}