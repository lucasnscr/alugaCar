package resource;

import dto.CarroDTO;
import dto.PesquisaCarroDTO;
import exceptions.ServicoException;
import exceptions.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import service.CarroService;

import java.util.List;

@RestController
@RequestMapping("/carro")
public class CarroResource {

    @Autowired
    private CarroService carroService;

    @RequestMapping(value="/", method= RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    public CarroDTO insert(@RequestParam("carroDTO") CarroDTO carroDTO)  throws ValidacaoException, ServicoException {
        CarroDTO carDTO = carroService.insert(carroDTO);
        return carDTO;
    }

    @RequestMapping(value="/atualizar", method= RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    public CarroDTO atualizar(@RequestParam("carroDTO") CarroDTO carroDTO)  throws ValidacaoException, ServicoException {
        CarroDTO carDTO = carroService.atualizar(carroDTO);
        return carDTO;
    }

    @RequestMapping(value="/inativar/{id}", method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public CarroDTO inativar(@PathVariable("id") Long id)  throws ValidacaoException, ServicoException {
        CarroDTO carDTO = carroService.inativar(id);
        return carDTO;
    }

    @RequestMapping(value = "/pesquisar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CarroDTO> pesquisaCarro(@RequestParam("pesquisaCarroDTO") PesquisaCarroDTO pesquisaCarroDTO)  throws ValidacaoException, ServicoException{
        List<CarroDTO> carroDTOS = carroService.pesquisaCarro(pesquisaCarroDTO);
        return carroDTOS;
    }

    @RequestMapping(value = "/pesquisar/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public CarroDTO carroDetalhe(@PathVariable("id") Long id)  throws ValidacaoException, ServicoException{
        CarroDTO carroDTO = carroService.pesquisaCarroId(id);
        return carroDTO;
    }






}
