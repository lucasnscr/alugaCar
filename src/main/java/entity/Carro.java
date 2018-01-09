package entity;

import enums.FlagAtivo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;

@Document(collection="carro")
@Entity
public class Carro {

	@Indexed(unique=true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private Long idCliente;

    @NotNull
    private Long idPedido;

    @NotNull
    private LocalDate dataInicioEmprestimo;

    @NotNull
    private LocalDate dataFimEmprestimo;

    @NotNull
    private String placa;

    @NotNull
    private Integer tipoCarro;

    @NotNull
    private Long kilometragem;

    @NotNull
    private Long kilometragemFinal;


    @NotNull
    private Long quantidadePedidos;

    @NotNull
    private Long ano;

    @NotNull
    private FlagAtivo ativo;

    @NotNull
    private Integer emprestado;

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

	public Integer getTipoCarro() {
		return tipoCarro;
	}

	public void setTipoCarro(Integer tipoCarro) {
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

	public Long getQuantidadePedidos() {
		return quantidadePedidos;
	}

	public void setQuantidadePedidos(Long quantidadePedidos) {
		this.quantidadePedidos = quantidadePedidos;
	}

	public Long getAno() {
		return ano;
	}

	public void setAno(Long ano) {
		this.ano = ano;
	}

	public FlagAtivo getAtivo() {
		return ativo;
	}

	public void setAtivo(FlagAtivo ativo) {
		this.ativo = ativo;
	}

	public Integer getEmprestado() {
		return emprestado;
	}

	public void setEmprestado(Integer emprestado) {
		this.emprestado = emprestado;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
}
