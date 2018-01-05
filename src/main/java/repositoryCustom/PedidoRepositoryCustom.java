package repositoryCustom;

import dto.PesquisaPedidoDTO;
import entity.Pedido;
import exceptions.ValidacaoException;

import java.util.List;

public interface PedidoRepositoryCustom {

    List<Pedido> pesquisaPedido(PesquisaPedidoDTO pesquisaPedidoDTO) throws ValidacaoException;

}
