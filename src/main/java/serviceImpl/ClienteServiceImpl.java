package serviceImpl;

import dto.ClienteDTO;
import entity.Cliente;
import enums.FlagAtivo;
import org.springframework.stereotype.Service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;


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
    public ClienteDTO insert(ClienteDTO clienteDTO){
        try{
            Cliente cliente = new Cliente();
            if(clienteDTO != null){
            	clienteDTO.setAtivo(FlagAtivo.ATIVO);
                BeanUtils.copyProperties(clienteDTO, cliente);
                cliente =  clienteRepository.save(cliente);
                BeanUtils.copyProperties(cliente, clienteDTO);
            }
        }catch (Exception e){
            //throw new Exception("Informações inválidas para cadastro");
            e.getMessage();
        }
        return clienteDTO;
    }

    @Override
    public ClienteDTO update(ClienteDTO clienteDTO){
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
            e.getMessage();
        }
		return clienteDTO;
    }

    @Override
    public ClienteDTO inativar(ClienteDTO clienteDTO){
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
            e.getMessage();
        }
        return clienteDTO;
    }

    @Override
    public List<ClienteDTO> findClientTipoAtivo(String tipo){
        List<ClienteDTO> clientesDTO = null;
        try{
        	List<Cliente> clientes = clienteRepository.findByTipoAndAtivo(tipo, FlagAtivo.ATIVO);
            if(CollectionUtils.isEmpty(clientes)){
               throw  new Exception("Busca inválida") ;
            }else {
            	BeanUtils.copyProperties(clientes, clientesDTO);
            }
        }catch(Exception e){
            e.getMessage();
        }
        return clientesDTO;
    }

    @Override
    public List<ClienteDTO> findAtivo(){
    	List<ClienteDTO> clientesDTO = new ArrayList<>();
    	List<Cliente> clientes = clienteRepository.findByAtivo(FlagAtivo.ATIVO);
    	for (Cliente cliente : clientes) {
    		ClienteDTO clienteDTO =  new ClienteDTO();
			BeanUtils.copyProperties(cliente, clienteDTO);
			clientesDTO.add(clienteDTO);
		}
    	return clientesDTO;
    }

    @Override
    public ClienteDTO findByIdAndAtivo(Long id){
    	ClienteDTO clienteDTO = null;
        Cliente cliente = clienteRepository.findByIdAndAtivo(id, FlagAtivo.ATIVO);
        BeanUtils.copyProperties(clienteDTO, cliente);
        return clienteDTO;
    }





}
