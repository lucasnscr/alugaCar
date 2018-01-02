package service;

import java.util.List;

import main.java.dto.ClienteDTO;

public interface ClienteService {

	ClienteDTO insert(ClienteDTO clienteDTO);

	ClienteDTO update(ClienteDTO clienteDTO);

	ClienteDTO inativar(ClienteDTO clienteDTO)

	List<ClienteDTO> findClientTipoAtivo(String tipo);

	List<ClienteDTO> findAtivo();

	ClienteDTO findByIdAndAtivo(Long id);
	
}
