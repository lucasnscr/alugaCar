package repository;

import entity.Pedido;
import enums.FlagAtivo;

import org.springframework.data.repository.CrudRepository;
import repositoryCustom.PedidoRepositoryCustom;

public interface PedidoRepository extends CrudRepository<Pedido, Long>, PedidoRepositoryCustom {

    Pedido findByIdAndAtivo(Long id, FlagAtivo ativo);

}
