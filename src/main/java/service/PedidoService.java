package service;

import dto.PedidoDTO;
import exceptions.ServicoException;
import exceptions.ValidacaoException;

import java.util.List;

public interface PedidoService {

    PedidoDTO insert(PedidoDTO pedidoDTO) throws ValidacaoException, ServicoException;
    PedidoDTO atualizar(Long id) throws ValidacaoException, ServicoException;
    List<PedidoDTO> pedidosPorData(PedidoDTO pedidoDTO) throws  ValidacaoException, ServicoException;
    List<PedidoDTO> pedidoPorCliente(Long idCliente) throws ValidacaoException, ServicoException;


}
