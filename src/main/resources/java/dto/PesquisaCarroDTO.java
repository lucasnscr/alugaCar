package dto;

import enums.Emprestado;
import enums.TipoCarro;

import java.io.Serializable;
import java.math.BigDecimal;

public class PesquisaCarroDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String marca;

    private Long ano;

    private Long kilometragemInicial;

    private Long KilometragemFinal;

    private String motorizacao;

    private Long lugares;

    private Emprestado emprestado;

    private TipoCarro tipoCarro;

    private BigDecimal valorInicial;

    private BigDecimal valorFinal;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Long getAno() {
        return ano;
    }

    public void setAno(Long ano) {
        this.ano = ano;
    }

    public Long getKilometragemInicial() {
        return kilometragemInicial;
    }

    public void setKilometragemInicial(Long kilometragemInicial) {
        this.kilometragemInicial = kilometragemInicial;
    }

    public Long getKilometragemFinal() {
        return KilometragemFinal;
    }

    public void setKilometragemFinal(Long kilometragemFinal) {
        KilometragemFinal = kilometragemFinal;
    }

    public String getMotorizacao() {
        return motorizacao;
    }

    public void setMotorizacao(String motorizacao) {
        this.motorizacao = motorizacao;
    }

    public Long getLugares() {
        return lugares;
    }

    public void setLugares(Long lugares) {
        this.lugares = lugares;
    }

    public Emprestado getEmprestado() {
        return emprestado;
    }

    public void setEmprestado(Emprestado emprestado) {
        this.emprestado = emprestado;
    }

    public TipoCarro getTipoCarro() {
        return tipoCarro;
    }

    public void setTipoCarro(TipoCarro tipoCarro) {
        this.tipoCarro = tipoCarro;
    }

    public BigDecimal getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(BigDecimal valorInicial) {
        this.valorInicial = valorInicial;
    }

    public BigDecimal getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(BigDecimal valorFinal) {
        this.valorFinal = valorFinal;
    }
}
