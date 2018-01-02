package main.java.service;

import main.java.dto.AdministradorDTO;
import main.java.entity.Administrador;
import main.java.enums.FlagAtivo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import main.java.repository.AdministradorRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    public AdministradorDTO insert(AdministradorDTO administradorDTO){
        try{
            Administrador administrador =  null;
            if(administradorDTO.getNome() != null){
                administradorDTO.setAtivo(FlagAtivo.ATIVO);
                administradorDTO.setCadastro(LocalDateTime.now());
                BeanUtils.copyProperties(administradorDTO, administrador);
                administradorRepository.save(administrador);
            }
        }catch (Exception e){
            e.getMessage();
        }
        return administradorDTO;
    }

    public AdministradorDTO inativar(AdministradorDTO administradorDTO){
        AdministradorDTO admDTORetorno =  null;
        try {
            Administrador administrador = administradorRepository.findById(administradorDTO.getId());
            if(administrador != null){
                BeanUtils.copyProperties(administradorDTO, administrador);
                administrador.setAtivo(FlagAtivo.INATIVO);
                administrador = administradorRepository.save(administrador);
                BeanUtils.copyProperties(administrador, admDTORetorno);
            }
        }catch(Exception e){
            e.getMessage();
        }

        return admDTORetorno;
    }

    public List<AdministradorDTO> findByAtivo(){
        List<AdministradorDTO>  administradoresDTO = new ArrayList<>();
        try{
            List<Administrador> administradores = administradorRepository.findByAtivo(FlagAtivo.ATIVO);
            if(!CollectionUtils.isEmpty(administradores)) {
                for (Administrador administrador : administradores) {
                    AdministradorDTO administradorDTO = new AdministradorDTO();
                    BeanUtils.copyProperties(administrador, administradorDTO);
                    administradoresDTO.add(administradorDTO);
                }
            }
        }catch (Exception e){
            e.getMessage();
        }
        return administradoresDTO;
    }

    public AdministradorDTO findByIdAtivo(Long id){
        AdministradorDTO administradorDTO = null;
        try{
            Administrador administrador = administradorRepository.findByIdAndAtivo(id, FlagAtivo.ATIVO);
            if(administrador != null){
                BeanUtils.copyProperties(administrador, administradorDTO);
            }
        }catch (Exception e){
            e.getMessage();
        }
        return administradorDTO;
    }
}
