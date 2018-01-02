package main.java.resource;

import main.java.dto.CarroDTO;
import main.java.dto.PesquisaCarroDTO;
import main.java.service.CarroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carro")
public class CarroResource {

    @Autowired
    private CarroService carroService;

    @RequestMapping(value="/", method= RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    public CarroDTO insert(@RequestParam("carroDTO") CarroDTO carroDTO) {
        CarroDTO carDTO = carroService.insert(carroDTO);
        return carDTO;
    }

    @RequestMapping(value="/atualizar", method= RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    public CarroDTO atualizar(@RequestParam("carroDTO") CarroDTO carroDTO) {
        CarroDTO carDTO = carroService.atualizar(carroDTO);
        return carDTO;
    }

    @RequestMapping(value="/inativar/{id}", method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public CarroDTO inativar(@PathVariable("id") Long id) {
        CarroDTO carDTO = carroService.inativar(id);
        return carDTO;
    }

    @RequestMapping(value = "/pesquisar", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CarroDTO> pesquisaCarro(@RequestParam("pesquisaCarroDTO") PesquisaCarroDTO pesquisaCarroDTO){
        List<CarroDTO> carroDTOS = carroService.pesquisaCarro(pesquisaCarroDTO);
        return carroDTOS;
    }

    @RequestMapping(value = "/pesquisar/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public CarroDTO carroDetalhe(@PathVariable("id") Long id){
        CarroDTO carroDTO = carroService.pesquisaCarroId(id);
        return carroDTO;
    }






}
