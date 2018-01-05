package repository;

import entity.Carro;
import enums.FlagAtivo;

import org.springframework.data.jpa.repository.JpaRepository;
import repositoryCustom.CarroRepositoryCustom;

import java.util.List;

public interface CarroRepository extends JpaRepository<Carro, Long>, CarroRepositoryCustom {

    Carro findById(Long id);
    List<Carro> findByAnoAndMarca(Long ano, String marca);
    List<Carro> findByAno(Long ano);
    Carro findByIdPedido(Long idPedido);
    Carro findByPlaca(String placa);
    List<Carro> findByIdCliente(Long idCliente);
    Carro findByIdClienteAndIdPedido(Long idCliente, Long idPedido);
    Carro findByIdAndAtivo(Long id, FlagAtivo ativo);

}
