package enums;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public enum Emprestado {

    EMPRESTADO(1),
    NAO_EMPRESTADO(0);

    private int valor;

    Emprestado(int valor){ this.valor = valor;}

    public int getEmprestado(){return valor;}
}
