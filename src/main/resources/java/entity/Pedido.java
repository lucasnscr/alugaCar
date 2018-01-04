package entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import enums.FlagAtivo;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private Long idCliente;

	@NotNull
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate dataInicioEmprestimo;
	
	@NotNull
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate dataFimEmprestimo;

	@NotNull
	private Long idCarro;

	@NotNull
	private FlagAtivo ativo;

	private Long idPedidoAtualizado;



}