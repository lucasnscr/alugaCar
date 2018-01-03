package serviceImpl;

import dto.AdministradorDTO;
import entity.Administrador;
import enums.FlagAtivo;
import exceptions.ServicoException;
import exceptions.ValidacaoException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import repository.AdministradorRepository;
import service.AdministradorService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdministradorServiceImpl implements AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    @Override
    public AdministradorDTO insert(AdministradorDTO administradorDTO) throws ValidacaoException, ServicoException{
        try{
            Administrador administrador =  null;
            if(administradorDTO.getNome() != null){
                administradorDTO.setAtivo(FlagAtivo.ATIVO);
                administradorDTO.setCadastro(LocalDateTime.now());
                BeanUtils.copyProperties(administradorDTO, administrador);
                administradorRepository.save(administrador);
            }
        }catch (Exception e){
            throw  new ServicoException(e.getMessage());
        }
        return administradorDTO;
    }

    @Override
    public AdministradorDTO inativar(AdministradorDTO administradorDTO) {
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

    @Override
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

    @Override
    public AdministradorDTO findByIdAtivo(Long id) {
        return null;
    }
}
