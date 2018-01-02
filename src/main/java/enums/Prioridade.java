package enums;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public enum Prioridade {
	
	PRESIDENTE(1),
	VICE_PRESIDENTE(2),
	DIRETOR(3),
	GESTOR(4),
	FUNCIONARIO(5);
	
	
	private int prioridade;
	
	Prioridade(int prioridade){
		this.prioridade = prioridade;
	}

	public int getPrioridade() {
		return prioridade;
	}
}
