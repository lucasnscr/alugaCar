package repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import entity.Pedido;
import repositoryCustom.PedidoMongoRepositoryCustom;

public interface PedidoMongoRepository extends MongoRepository<Pedido, Long>, PedidoMongoRepositoryCustom{

	Pedido findFirstById(Long id);
	
}
