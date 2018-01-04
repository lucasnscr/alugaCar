package repositoryCustom;

import dto.PesquisaPedidoDTO;
import entity.Pedido;

import java.util.List;

public interface PedidoRepositoryCustom {

    List<Pedido> pesquisaPedido(PesquisaPedidoDTO pesquisaPedidoDTO);

}
