package serviceImpl;

import dto.PedidoDTO;
import dto.PesquisaPedidoDTO;
import entity.Carro;
import entity.Pedido;
import enums.FlagAtivo;
import exceptions.ServicoException;
import exceptions.ValidacaoException;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MensagensErro.MensagemErro;
import repository.CarroRepository;
import repository.PedidoMongoRepository;
import repository.PedidoRepository;
import service.PedidoService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    
    @Autowired
    private PedidoMongoRepository pedidoMongoRepository;

    @Autowired
    private CarroRepository carroRepository;

    @Override
    public PedidoDTO insert(PedidoDTO pedidoDTO) throws ValidacaoException, ServicoException {
        Pedido pedido =  null;
        try{
            BeanUtils.copyProperties(pedidoDTO, pedido);
            Boolean carroDisponivel = carroDisponivel(pedidoDTO.getIdCarro(), pedidoDTO.getDataInicioEmprestimo(), pedidoDTO.getDataFimEmprestimo());
            if(carroDisponivel){
                pedido = pedidoRepository.save(pedido);
                BeanUtils.copyProperties(pedido, pedidoDTO);
            }
        }catch (Exception e){
            throw  new ValidacaoException("Pedido não realizado");
        }
        return pedidoDTO;
    }

    @Override
    public PedidoDTO atualizar(PedidoDTO pedidoDTO) throws ValidacaoException, ServicoException {
        try{
            Long id = pedidoDTO.getId();
            Pedido pedido = pedidoRepository.findByIdAndAtivo(id, FlagAtivo.ATIVO);
            if(pedido != null){
                pedido.setAtivo(FlagAtivo.INATIVO);
                pedidoMongoRepository.updatePedido(pedido.getId());
                pedidoRepository.save(pedido);
                Long idPedidoInativado = pedido.getId();
                BeanUtils.copyProperties(pedidoDTO, pedido);
                pedido.setIdPedidoAtualizado(idPedidoInativado);
                pedido = pedidoRepository.save(pedido);
                BeanUtils.copyProperties(pedido, pedidoDTO);
            }
        }catch (Exception e){
            throw  new ValidacaoException(MensagemErro.ERRO_ALTERA_PEDIDO);
        }
        return pedidoDTO;
    }

    @Override
    public PedidoDTO cancelar(Long id) throws ValidacaoException, ServicoException {
    	PedidoDTO pedidoDTO = null;
        try {
        	Pedido pedido = pedidoRepository.findByIdAndAtivo(id, FlagAtivo.ATIVO);
        	if(pedido != null) {
        		pedido.setAtivo(FlagAtivo.INATIVO);
        		pedidoRepository.save(pedido);
        		BeanUtils.copyProperties(pedido, pedidoDTO);
        	}
			
		} catch (Exception e) {
			throw new ServicoException(MensagemErro.ERRO_CANCELAR_PEDIDO);
		} 
    	
    	return pedidoDTO;
    }

    @Override
    public List<PedidoDTO> pesquisaPedido(PesquisaPedidoDTO pesquisaPedidoDTO) throws ValidacaoException, ServicoException {
    	
    	List<PedidoDTO> pedidosDTOList = new ArrayList<>();
    	try {
    		List<Pedido> pedidoList = pedidoRepository.pesquisaPedido(pesquisaPedidoDTO);
    		if(CollectionUtils.isNotEmpty(pedidoList)) {
    			for (Pedido pedido : pedidoList) {
    				PedidoDTO pedidoDTO = new PedidoDTO();
    				BeanUtils.copyProperties(pedido, pedidoDTO);
    				pedidosDTOList.add(pedidoDTO);
				}
    		}
    	}catch (Exception e) {
    		throw new ServicoException(MensagemErro.ERRO_NA_PESQUISA_PEDIDO);
    	
		}
    	return pedidosDTOList;
    }

    @Override
    public PedidoDTO pesquisaPorId(Long id) throws ValidacaoException, ServicoException {
    	
    	PedidoDTO pedidoDTO = null;
    	
    	try {
    		Pedido pedido = pedidoRepository.findByIdAndAtivo(id, FlagAtivo.ATIVO);
    		if(pedido != null) {
    			BeanUtils.copyProperties(pedido, pedidoDTO);
    		}
    	}catch (Exception e) {
    		throw new ServicoException(MensagemErro.ERRO_NA_PESQUISA_PEDIDO_POR_ID);
		}
        return pedidoDTO;
    }

    private Boolean carroDisponivel(Long idCarro, LocalDate inicio, LocalDate fim)throws ValidacaoException{

        Boolean disponibilidade = null;

        try{
            Carro carro = carroRepository.findById(idCarro);
            if (carro != null){
                Integer emprestado = carro.getEmprestado();
                if(emprestado == 1){
                    disponibilidade = false;
                }else{
                    disponibilidade = true;
                }
            }
        }catch (Exception e){
            throw new ValidacaoException(MensagemErro.ERRO_DISPONIBILIDADE_CARRO);
        }
        return disponibilidade;
    }

}
