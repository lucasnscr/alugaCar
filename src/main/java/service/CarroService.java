package service;

import java.util.List;

import dto.CarroDTO;
import dto.PesquisaCarroDTO;

public interface CarroService {
	
	CarroDTO insert(CarroDTO carroDTO); 
	
	CarroDTO atualizar(CarroDTO carroDTO);

	CarroDTO inativar(Long id);
	
	List<CarroDTO> pesquisaCarro(PesquisaCarroDTO pesquisaCarroDTO);

    CarroDTO pesquisaCarroId(Long id);
	
}
