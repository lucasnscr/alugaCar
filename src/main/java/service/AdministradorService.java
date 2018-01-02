package service;

import java.util.List;
import dto.AdministradorDTO;

public interface AdministradorService {

    AdministradorDTO insert(AdministradorDTO administradorDTO);
    AdministradorDTO inativar(AdministradorDTO administradorDTO);
    List<AdministradorDTO> findByAtivo();
    AdministradorDTO findByIdAtivo(Long id);


}
