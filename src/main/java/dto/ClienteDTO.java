package dto;

import enums.FlagAtivo;
import java.time.LocalDateTime;

public class ClienteDTO {

        private long id;

        private String name;

        private String tipo;

        private FlagAtivo ativo;

        private LocalDateTime atualizacao;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTipo(){
            return tipo;
        }

        public void setTipo(String tipo){
            this.tipo = tipo;
        }

        public FlagAtivo getAtivo() {
            return ativo;
        }

        public void setAtivo(FlagAtivo ativo) {
            this.ativo = ativo;
        }

        public LocalDateTime getAtualizacao() {
            return atualizacao;
        }

        public void setAtualizacao(LocalDateTime atualizacao) {
            this.atualizacao = atualizacao;
        }

    }
