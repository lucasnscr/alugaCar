package main.java.dto;

import main.java.enums.Emprestado;
import main.java.enums.Prioridade;

import java.io.Serializable;

public class PesquisaCarroDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String marca;

    private Long ano;

    private Long kilometragemInicial;

    private Long KilometragemFinal;

    private String motorizacao;

    private Long lugares;

    private Emprestado emprestado;

    private Prioridade prioridade;

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

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }
}
