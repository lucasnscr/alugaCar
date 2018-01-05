package repositoryImpl;

import MensagensErro.MensagemErro;
import dto.PesquisaPedidoDTO;
import entity.Carro;
import entity.Pedido;
import enums.FlagAtivo;
import exceptions.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import repository.CarroRepository;
import repositoryCustom.PedidoRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Lucas Nascimento
 *
 */
public class PedidoRepositoryImpl implements PedidoRepositoryCustom {

    @Autowired
    private EntityManager entityManager;
    
    @Autowired
    private CarroRepository carroRepository;
    
    @SuppressWarnings("unchecked")
	@Override
    public List<Pedido> pesquisaPedido(PesquisaPedidoDTO pesquisaPedidoDTO) throws ValidacaoException {
        
    	Carro carro = null;
    	
    	int cont = 0;
    	Map<Integer, Object> parametros =  new HashMap<>();
        StringBuilder sql = new StringBuilder();
        
        Long idCarro = pesquisaPedidoDTO.getIdCarro();
        if(idCarro != null) {
        	carro = carroRepository.findByIdAndAtivo(idCarro, FlagAtivo.ATIVO);
        	if(carro == null) {
        		throw new ValidacaoException(MensagemErro.ERRO_CARRO_INVALIDO);
        	}
        }else {
        	throw new ValidacaoException(MensagemErro.ERRO_CARRO_NAO_INFORMADO);
        }
        
        sql.append(" SELECT p FROM Pedido")
           .append(" WHERE ");
        
        if(pesquisaPedidoDTO.getIdCliente() != null) {
        	sql.append(" idCliente = :idCliente ");
        	parametros.put(cont++, pesquisaPedidoDTO.getIdCliente());
        }
        
        if(pesquisaPedidoDTO.getIdCarro() != null) {
        	sql.append(" AND ")
        	   .append(" idCarro = :idCarro");
        	parametros.put(cont++, pesquisaPedidoDTO.getIdCarro());
        }
        
        Boolean validaData = validaData(pesquisaPedidoDTO.getDataInicioEmprestimo(), pesquisaPedidoDTO.getDataInicioEmprestimo());
        	if(pesquisaPedidoDTO.getDataInicioEmprestimo() != null && pesquisaPedidoDTO.getDataInicioEmprestimo() != null){
        		if(validaData) {
        			sql.append(" AND ")
        			   .append(" dataEmprestimo BETWEEN :inicio AND :fim ");
        			parametros.put(cont++, pesquisaPedidoDTO.getDataInicioEmprestimo());
        			parametros.put(cont++, pesquisaPedidoDTO.getDataInicioEmprestimo());
        		}else {
        			throw new ValidacaoException(MensagemErro.ERRO_DATA_PEDIDO);
        		}
        	}else if(pesquisaPedidoDTO.getDataInicioEmprestimo() != null && pesquisaPedidoDTO.getDataFimEmprestimo() == null) {
        		sql.append(" AND ")
        		   .append(" dataEmprestimo >= :inicio ");
        		parametros.put(cont++, pesquisaPedidoDTO.getDataInicioEmprestimo());
        		
        	}else if(pesquisaPedidoDTO.getDataInicioEmprestimo() == null && pesquisaPedidoDTO.getDataFimEmprestimo() != null) {
        		sql.append(" AND ")
        		   .append(" DATA_EMPRESTIMO <= :fim ");
        		parametros.put(cont++, pesquisaPedidoDTO.getDataFimEmprestimo());
        	}
        
        Query query = entityManager.createQuery(sql.toString());
        for (int i = 0; i < parametros.size(); i++) {
        	query.setParameter(i, parametros.get(i));
		}
        
        List<Pedido> pedidos = query.getResultList();
        return pedidos;
    }
    
    private Boolean validaData(LocalDate inicio, LocalDate fim)throws ValidacaoException{
		Boolean dataValida = null;
		if (fim.isAfter(inicio)) {
			dataValida = true;
		} else {
			dataValida = false;
		}
		return dataValida;
    }

    
}
