package dto;

import enums.FlagAtivo;

import java.io.Serializable;
import java.time.LocalDateTime;

public class AdministradorDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String nome;

    private LocalDateTime cadastro;

    private FlagAtivo ativo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public LocalDateTime getCadastro() {
        return cadastro;
    }

    public void setCadastro(LocalDateTime cadastro) {
        this.cadastro = cadastro;
    }

    public FlagAtivo getAtivo() {
        return ativo;
    }

    public void setAtivo(FlagAtivo ativo) {
        this.ativo = ativo;
    }
}