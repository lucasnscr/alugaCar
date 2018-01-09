package repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import entity.Carro;
import repositoryCustom.CarroMongoRepositoryCustom;

public interface CarroMongoRepository extends MongoRepository<Carro, Long>, CarroMongoRepositoryCustom {
	
	Carro findFirsById(Long id);

}
