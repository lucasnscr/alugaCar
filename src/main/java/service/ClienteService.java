package service;

import dto.ClienteDTO;
import exceptions.ServicoException;
import exceptions.ValidacaoException;

import java.util.List;

public interface ClienteService {

	ClienteDTO insert(ClienteDTO clienteDTO) throws ValidacaoException, ServicoException;

	ClienteDTO update(ClienteDTO clienteDTO) throws ValidacaoException, ServicoException;

	ClienteDTO inativar(ClienteDTO clienteDTO) throws ValidacaoException, ServicoException;

	List<ClienteDTO> findClientTipoAtivo(String tipo) throws ValidacaoException, ServicoException;

	List<ClienteDTO> findAtivo() throws ValidacaoException, ServicoException;

	ClienteDTO findByIdAndAtivo(Long id) throws ValidacaoException, ServicoException;
	
}
