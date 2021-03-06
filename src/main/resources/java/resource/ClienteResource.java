package resource;

import dto.ClienteDTO;
import exceptions.ServicoException;
import exceptions.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import service.ClienteService;

import java.util.List;


@RestController
@RequestMapping("/cliente")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;


    @RequestMapping(value="/", method= RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public ClienteDTO insert(@RequestParam("clientDTO") ClienteDTO clienteDTO)  throws ValidacaoException, ServicoException {
        ClienteDTO cliDTO = clienteService.insert(clienteDTO);
        return cliDTO;
    }

    @RequestMapping(value="/update", method= RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public ClienteDTO update (@RequestParam("clientDTO") ClienteDTO clienteDTO)  throws ValidacaoException, ServicoException {
        ClienteDTO cliDTO = clienteService.update(clienteDTO);
        return cliDTO;
    }

    @RequestMapping(value="/inativar", method= RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public ClienteDTO inativar(ClienteDTO clienteDTO)  throws ValidacaoException, ServicoException{
    	ClienteDTO cliDTO = clienteService.inativar(clienteDTO);
    	return cliDTO;
    }

    @RequestMapping(value="/{tipo}", method= RequestMethod.GET, produces= MediaType.APPLICATION_XML_VALUE)
    public List<ClienteDTO> getClientTipo(@PathVariable("tipo") String tipo)   throws ValidacaoException, ServicoException{
        List<ClienteDTO> clients = clienteService.findClientTipoAtivo(tipo);
        return clients;
    }

    @RequestMapping(value="/", method= RequestMethod.GET, produces= MediaType.APPLICATION_XML_VALUE)
    public List<ClienteDTO> getClientAtivo(@PathVariable("tipo") String tipo)  throws ValidacaoException, ServicoException {
        List<ClienteDTO> clients = clienteService.findAtivo();
        return clients;
    }
}