package service;

import dto.PedidoDTO;
import dto.PesquisaPedidoDTO;
import exceptions.ServicoException;
import exceptions.ValidacaoException;

import java.util.List;

public interface PedidoService {

    PedidoDTO insert(PedidoDTO pedidoDTO) throws ValidacaoException, ServicoException;

    PedidoDTO atualizar(PedidoDTO pedidoDTO) throws ValidacaoException, ServicoException;

    PedidoDTO cancelar (Long id) throws  ValidacaoException, ServicoException;

    List<PedidoDTO> pesquisaPedido(PesquisaPedidoDTO pedidoDTO) throws  ValidacaoException, ServicoException;

    PedidoDTO pesquisaPorId(Long id) throws  ValidacaoException, ServicoException;



}
