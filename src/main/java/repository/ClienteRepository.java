package main.java.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import main.java.entity.Cliente;
import main.java.enums.FlagAtivo;

public interface ClienteRepository extends CrudRepository<Cliente, Long>{

	Optional<Cliente> findOneByNameIgnoreCase(String nome);

	List<Cliente> findByTipoAndAtivo(String tipo, FlagAtivo ativo);

	 Cliente findByIdAndAtivo(Long id, FlagAtivo ativo);

	 List<Cliente> findByAtivo(FlagAtivo ativo);
}
