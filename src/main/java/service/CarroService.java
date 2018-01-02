package service;

import java.util.List;

import main.java.dto.CarroDTO;

public interface CarroService {
	
	CarroDTO insert(CarroDTO carroDTO); 
	
	CarroDTO atualizar(CarroDTO carroDTO);

	CarroDTO inativar(Long id);
	
	List<CarroDTO> pesquisaCarro(main.java.dto.PesquisaCarroDTO pesquisaCarroDTO);

    CarroDTO pesquisaCarroId(Long id);
	
}
