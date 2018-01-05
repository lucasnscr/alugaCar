package feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dto.PedidoDTO;
import dto.PesquisaPedidoDTO;
import exceptions.ServicoException;
import exceptions.ValidacaoException;

@FeignClient("pedido")
public interface PedidoClient {
	
	@RequestMapping(value = "/pesquisaPedido", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PedidoDTO> pesquisaPedido(PesquisaPedidoDTO pesquisaPedidoDTO) throws ValidacaoException, ServicoException;
	

}
