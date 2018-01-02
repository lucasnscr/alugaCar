package main.java.repository;

import main.java.entity.Administrador;
import main.java.enums.FlagAtivo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdministradorRepository extends CrudRepository<Administrador, Long> {

    List<Administrador> findByAtivo(FlagAtivo ativo);

    Administrador findByIdAndAtivo(Long id, FlagAtivo ativo);

    Administrador findById(Long id);
}
