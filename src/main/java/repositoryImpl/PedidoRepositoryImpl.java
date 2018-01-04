package repositoryImpl;

import dto.PesquisaPedidoDTO;
import entity.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import repositoryCustom.PedidoRepositoryCustom;

import javax.persistence.EntityManager;
import java.util.List;

public class PedidoRepositoryImpl implements PedidoRepositoryCustom {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Pedido> pesquisaPedido(PesquisaPedidoDTO pesquisaPedidoDTO) {
        return null;
    }
}
