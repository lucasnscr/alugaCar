package service;

import dto.CarroDTO;
import dto.PesquisaCarroDTO;
import exceptions.ServicoException;
import exceptions.ValidacaoException;

import java.util.List;

public interface CarroService {
	
	CarroDTO insert(CarroDTO carroDTO) throws ValidacaoException, ServicoException;
	
	CarroDTO atualizar(CarroDTO carroDTO) throws ValidacaoException, ServicoException;

	CarroDTO inativar(Long id) throws ValidacaoException, ServicoException;
	
	List<CarroDTO> pesquisaCarro(PesquisaCarroDTO pesquisaCarroDTO) throws ValidacaoException, ServicoException;

    CarroDTO pesquisaCarroId(Long id) throws ValidacaoException, ServicoException;
	
}
