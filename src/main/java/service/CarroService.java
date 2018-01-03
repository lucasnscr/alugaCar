package service;

import java.util.List;

import dto.CarroDTO;
import dto.PesquisaCarroDTO;
import exceptions.ServicoException;
import exceptions.ValidacaoException;

public interface CarroService {
	
	CarroDTO insert(CarroDTO carroDTO) throws ValidacaoException, ServicoException;;
	
	CarroDTO atualizar(CarroDTO carroDTO) throws ValidacaoException, ServicoException;;

	CarroDTO inativar(Long id) throws ValidacaoException, ServicoException;;
	
	List<CarroDTO> pesquisaCarro(PesquisaCarroDTO pesquisaCarroDTO) throws ValidacaoException, ServicoException;;

    CarroDTO pesquisaCarroId(Long id) throws ValidacaoException, ServicoException;;
	
}
