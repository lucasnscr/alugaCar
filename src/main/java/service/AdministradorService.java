package service;


import java.util.List;
import main.java.dto.AdministradorDTO;

public interface AdministradorService {

    AdministradorDTO insert(main.java.dto.AdministradorDTO administradorDTO);
    AdministradorDTO inativar(main.java.dto.AdministradorDTO administradorDTO);
    List<AdministradorDTO> findByAtivo();
    AdministradorDTO findByIdAtivo(Long id);


}
