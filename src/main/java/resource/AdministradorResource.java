package resource;

import dto.AdministradorDTO;
import entity.Administrador;
import exceptions.ServicoException;
import exceptions.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import service.AdministradorService;

import java.util.List;

@RestController
@RequestMapping("/admiinistrador")
public class AdministradorResource {

    @Autowired
    private AdministradorService administradorService;

    @RequestMapping(value="/insert", method= RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    public AdministradorDTO insert(@RequestParam("clientDTO") AdministradorDTO administradorDTO) throws ServicoException, ValidacaoException{
        AdministradorDTO admDTO = administradorService.insert(administradorDTO);
        return admDTO;
    }

    @RequestMapping(value="/insert", method= RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    public AdministradorDTO inativar(@RequestParam("clientDTO") AdministradorDTO administradorDTO) throws ValidacaoException, ServicoException {
        AdministradorDTO admDTO =  administradorService.inativar(administradorDTO);
        return admDTO;
    }

    @RequestMapping(value="/findByAtivo", method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public List<AdministradorDTO> findByAtivo() throws ValidacaoException, ServicoException {
        List<AdministradorDTO> admList = administradorService.findByAtivo();
        return admList;
    }

    @RequestMapping(value="/findByIdAtivo/{id}", method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public AdministradorDTO findByIdAtivo(@PathVariable("id") Long id) throws ValidacaoException, ServicoException {
        AdministradorDTO admDTO = administradorService.findByIdAtivo(id);
        return admDTO;
    }


}
