package repository;

import java.util.List;
import java.util.Optional;

import entity.Cliente;
import enums.FlagAtivo;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long>{

	Optional<Cliente> findOneByNameIgnoreCase(String nome);

	List<Cliente> findByTipoAndAtivo(String tipo, FlagAtivo ativo);

	 Cliente findByIdAndAtivo(Long id, FlagAtivo ativo);

	 List<Cliente> findByAtivo(FlagAtivo ativo);
}
