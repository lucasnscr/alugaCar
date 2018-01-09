package repositoryImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.WriteResult;

import entity.Carro;
import entity.Pedido;
import enums.FlagAtivo;
import repositoryCustom.CarroMongoRepositoryCustom;

public class CarroMongoRepositoryImpl implements CarroMongoRepositoryCustom {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public Carro updateCarro(Long id) {
		
		Carro carro = null;
		
		Query query = new Query(Criteria.where("id").is(id));
		Update update = new Update();
		update.set("ativo", FlagAtivo.ATIVO);
		WriteResult result = mongoTemplate.updateFirst(query, update, Pedido.class);
		if(result != null) {
			carro = (Carro) result.getUpsertedId();
		}else {
			return null;
		}
		return carro;
	}
}
