package service;

import java.util.List;
import dto.AdministradorDTO;
import exceptions.ServicoException;
import exceptions.ValidacaoException;

public interface AdministradorService {

    AdministradorDTO insert(AdministradorDTO administradorDTO) throws ValidacaoException, ServicoException;;
    AdministradorDTO inativar(AdministradorDTO administradorDTO) throws ValidacaoException, ServicoException;;
    List<AdministradorDTO> findByAtivo() throws ValidacaoException, ServicoException;;
    AdministradorDTO findByIdAtivo(Long id) throws ValidacaoException, ServicoException;;


}
