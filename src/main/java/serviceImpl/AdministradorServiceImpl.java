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

import MensagensErro.MensagemErro;
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
            throw  new ServicoException(MensagemErro.ERRO_INSERIR_ADM);
        }
        return administradorDTO;
    }

    @Override
    public AdministradorDTO inativar(AdministradorDTO administradorDTO) throws ValidacaoException, ServicoException {
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
            throw new ServicoException(MensagemErro.ERRO_INATIVAR_ADM);
        }

        return admDTORetorno;
    }

    @Override
    public List<AdministradorDTO> findByAtivo() throws ValidacaoException, ServicoException{
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
            throw new ValidacaoException(MensagemErro.ERRO_PESQUISAR_ADM);
        }
        return administradoresDTO;
    }

    @Override
    public AdministradorDTO findByIdAtivo(Long id) throws ValidacaoException, ServicoException {
    	AdministradorDTO administradorDTO = null;
    	try {
    		Administrador administrador = administradorRepository.findByIdAndAtivo(id, FlagAtivo.ATIVO);
    		if(administrador != null) {
    			BeanUtils.copyProperties(administrador, administradorDTO);
    		}
    	}catch (Exception e) {
			throw new ValidacaoException(MensagemErro.ERRO_PESQUISAR_ADM);
		}
        return administradorDTO;
    }
}
