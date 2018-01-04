package dto;

import enums.Emprestado;
import enums.FlagAtivo;
import enums.TipoCarro;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class CarroDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private Long idCliente;

	private Long idPedido;

	@NotNull
	private String placa;

	@NotNull
	private TipoCarro tipoCarro;

	@NotNull
	private Long kilometragem;

	@NotNull
	private Long kilometragemFinal;

	@NotNull
	private FlagAtivo ativo;

	@NotNull
	private Emprestado emprestado;

	@NotNull
	private BigDecimal valor;

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

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public TipoCarro getTipoCarro() {
		return tipoCarro;
	}

	public void setTipoCarro(TipoCarro tipoCarro) {
		this.tipoCarro = tipoCarro;
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

	public Emprestado getEmprestado() {
		return emprestado;
	}

	public void setEmprestado(Emprestado emprestado) {
		this.emprestado = emprestado;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
}
