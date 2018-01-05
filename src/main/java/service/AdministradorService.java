package service;

import dto.AdministradorDTO;
import exceptions.ServicoException;
import exceptions.ValidacaoException;

import java.util.List;

public interface AdministradorService {

    AdministradorDTO insert(AdministradorDTO administradorDTO) throws ValidacaoException, ServicoException;
    
    AdministradorDTO inativar(AdministradorDTO administradorDTO) throws ValidacaoException, ServicoException;
    
    List<AdministradorDTO> findByAtivo() throws ValidacaoException, ServicoException;
    
    AdministradorDTO findByIdAtivo(Long id) throws ValidacaoException, ServicoException;


}
