package repository;

import entity.Pedido;
import org.springframework.data.repository.CrudRepository;
import repositoryCustom.PedidoRepositoryCustom;

public interface PedidoRepository extends CrudRepository<Pedido, Long>, PedidoRepositoryCustom {

    Pedido findById(Long id);



}
