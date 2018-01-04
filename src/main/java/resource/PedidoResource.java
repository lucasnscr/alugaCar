package resource;

import dto.PedidoDTO;
import dto.PesquisaPedidoDTO;
import exceptions.ServicoException;
import exceptions.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import service.PedidoService;

import java.util.List;

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

    public PedidoDTO atualizar(@RequestParam("pedidoDTO") PedidoDTO pedidoDTO) throws  ValidacaoException, ServicoException{
	    PedidoDTO pedDTO = pedidoService.atualizar(pedidoDTO);
	    return pedDTO;
    }

    @RequestMapping(value = "/cancelar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public PedidoDTO cancelar(@PathVariable("id") Long id) throws ValidacaoException, ServicoException{
        PedidoDTO pedidoDTO = pedidoService.cancelar(id);
        return  pedidoDTO;
    }

    @RequestMapping(value = "/pesquisaPedido", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PedidoDTO> pesquisaPedido(@RequestParam("pesquisaPedidoDTO")PesquisaPedidoDTO pesquisaPedidoDTO) throws ServicoException, ValidacaoException{
	    List<PedidoDTO> pedidosDTO =  pedidoService.pesquisaPedido(pesquisaPedidoDTO);
	    return pedidosDTO;
    }

    public PedidoDTO pesquisaPedidoPorId(@PathVariable("id") Long id) throws ServicoException, ValidacaoException{
	    PedidoDTO pedidoDTO = pedidoService.pesquisaPorId(id);
	    return pedidoDTO;
    }

	

}