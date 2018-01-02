package main.java.repository;


import org.springframework.data.repository.CrudRepository;

import main.java.entity.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Long> {



}
