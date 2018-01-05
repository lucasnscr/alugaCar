package serviceImpl;

import dto.ClienteDTO;
import entity.Cliente;
import enums.FlagAtivo;
import exceptions.ServicoException;
import exceptions.ValidacaoException;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MensagensErro.MensagemErro;
import repository.ClienteRepository;
import service.ClienteService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public ClienteDTO insert(ClienteDTO clienteDTO) throws ValidacaoException, ServicoException{
        try{
            Cliente cliente = new Cliente();
            if(clienteDTO != null){
            	clienteDTO.setAtivo(FlagAtivo.ATIVO);
                BeanUtils.copyProperties(clienteDTO, cliente);
                cliente =  clienteRepository.save(cliente);
                BeanUtils.copyProperties(cliente, clienteDTO);
            }
        }catch (Exception e){
            throw new ValidacaoException(MensagemErro.ERRO_INSERIR_CLIENTE);
        }
        return clienteDTO;
    }

    @Override
    public ClienteDTO update(ClienteDTO clienteDTO) throws ServicoException, ValidacaoException{
        try{
            Long id  = clienteDTO.getId();
            Cliente cliente = clienteRepository.findOne(id);
			if(cliente != null){
			    BeanUtils.copyProperties(clienteDTO, cliente);
			    cliente.setAtivo(clienteDTO.getAtivo());
			    cliente.setAtualizacao(LocalDateTime.now());
			    cliente = clienteRepository.save(cliente);
			    BeanUtils.copyProperties(cliente, clienteDTO);			    
			}
        }catch (Exception e){
        	throw new ValidacaoException(MensagemErro.ERRO_ATUALIZAR_CLIENTE);
        }
		return clienteDTO;
    }

    @Override
    public ClienteDTO inativar(ClienteDTO clienteDTO) throws ValidacaoException, ServicoException{
        Cliente cliente =  new Cliente();
        try{
            Long id = clienteDTO.getId();
            if(!id.equals(null)){
                BeanUtils.copyProperties(clienteDTO, cliente);
                cliente.setAtivo(FlagAtivo.INATIVO);
                cliente.setAtualizacao(LocalDateTime.now());
                cliente = clienteRepository.save(cliente);
            }
        }catch (Exception e){
        	throw new ValidacaoException(MensagemErro.ERRO_INATIVAR_CLIENTE);
        }
        return clienteDTO;
    }

    @Override
    public List<ClienteDTO> findClientTipoAtivo(String tipo) throws ValidacaoException, ServicoException{
        List<ClienteDTO> clientesDTO = new ArrayList<>();
        try{
        	List<Cliente> clientes = clienteRepository.findByTipoAndAtivo(tipo, FlagAtivo.ATIVO);
        	if(CollectionUtils.isNotEmpty(clientes)) {
        		for (Cliente cliente : clientes) {
					ClienteDTO clienteDTO =  new ClienteDTO();
					BeanUtils.copyProperties(cliente, clientesDTO);
					clientesDTO.add(clienteDTO);
				}
            }else {
            	throw  new ValidacaoException(MensagemErro.BUSCA_NAO_TEVE_RESULTADO) ;
            }
        }catch(Exception e){
            throw new ServicoException(MensagemErro.ERRO_BUSCA_CLIENTE);
        }
        return clientesDTO;
    }

    @Override
    public List<ClienteDTO> findAtivo() throws ValidacaoException, ServicoException{
    	List<ClienteDTO> clientesDTO = new ArrayList<>();
    	try {
    		List<Cliente> clientes = clienteRepository.findByAtivo(FlagAtivo.ATIVO);
    		if(CollectionUtils.isNotEmpty(clientes)) {
    			for (Cliente cliente : clientes) {
    				ClienteDTO clienteDTO =  new ClienteDTO();
    				BeanUtils.copyProperties(cliente, clienteDTO);
    				clientesDTO.add(clienteDTO);
    			}
    		}else{
    			throw  new ValidacaoException(MensagemErro.BUSCA_NAO_TEVE_RESULTADO) ;
    		}
    	}catch (Exception e) {
    		throw new ServicoException(MensagemErro.ERRO_BUSCA_CLIENTE);
		}
    	return clientesDTO;
    }

    @Override 
    public ClienteDTO findByIdAndAtivo(Long id) throws ValidacaoException, ServicoException{
    	ClienteDTO clienteDTO = null;
    	try {
    		Cliente cliente = clienteRepository.findByIdAndAtivo(id, FlagAtivo.ATIVO);
    		if(cliente != null) {
    			BeanUtils.copyProperties(clienteDTO, cliente);    			
    		}
    	}catch (Exception e) {
    		throw new ServicoException(MensagemErro.ERRO_BUSCA_CLIENTE);
		}
    	return clienteDTO;
    }





}
