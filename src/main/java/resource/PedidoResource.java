package main.java.resource;


import dto.PedidoDTO;
import exceptions.ServicoException;
import exceptions.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoResource {

	@Autowired
	private PedidoService pedidoService;
	
	@RequestMapping(value="/", method= RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public PedidoDTO insert(@RequestParam("pedidoDTO") PedidoDTO pedidoDTO) throws ValidacaoException, ServicoException {
        PedidoDTO pedDTO = pedidoService.insert(pedidoDTO);
        return pedDTO;
    }
	

}