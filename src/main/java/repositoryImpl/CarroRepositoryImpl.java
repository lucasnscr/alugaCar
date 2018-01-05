package repositoryImpl;

import dto.PesquisaCarroDTO;
import entity.Carro;
import exceptions.ValidacaoException;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import repositoryCustom.CarroRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Lucas Nascimento
 */

@Transactional
public class CarroRepositoryImpl implements CarroRepositoryCustom {

    @Autowired
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
	@Override
    public List<Carro> findByKmInicialKmFinal(Long kilometragemInicial, Long kilometragemFinal) {

        StringBuilder sql =  new StringBuilder();

        sql.append(" SELECT carro FROM Carro")
           .append(" WHERE ")
           .append(" KILOMETRAGEM BETWEEN :kilometragemInicial AND :kilometragemFinal ");

        Query query = entityManager.createQuery(sql.toString());
        query.setParameter(1, kilometragemInicial);
        query.setParameter(2, kilometragemFinal);

        List<Carro> carros = query.getResultList();
        
        return carros;
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<Carro> findByDataInicioAndDataFim(LocalDate inicio, LocalDate fim) {

        StringBuilder sql = new StringBuilder();

        sql.append(" SELECT * FROM CARRO ")
           .append(" WHERE ")
           .append(" DATA_EMPRESTIMO_INICIO >= ?  ")
           .append(" AND DATA_EMPRESTIMO_FIM <= ? ");

        Query query = entityManager.createNativeQuery(sql.toString());
        query.setParameter(1, inicio);
        query.setParameter(2, fim);

        List<Carro> carros = query.getResultList();
        
        return carros;
        
    }

	@SuppressWarnings("unchecked")
	@Override
    public List<Carro> pesquisaCarro(PesquisaCarroDTO pesquisaCarroDTO) throws ValidacaoException {

        StringBuilder sql = new StringBuilder();
        int cont = 0;
        Map<Integer, Object> parametros =  new HashMap<>();

        sql.append(" SELECT carro FROM Carro " )
                .append(" WHERE ");

        if(pesquisaCarroDTO.getMarca() != null){
            sql.append("  marca = :marca ");
            parametros.put(cont++, pesquisaCarroDTO.getMarca());
        }

        if(pesquisaCarroDTO.getAno() != null){
            sql.append(" AND ")
               .append(" ano = :ano ");
            parametros.put(cont++, pesquisaCarroDTO.getAno());
        }

        if(pesquisaCarroDTO.getKilometragemInicial() != null && pesquisaCarroDTO.getKilometragemFinal() != null){
            sql.append(" AND")
               .append(" kilometragem BETWEEN :inicio AND :fim ");
            parametros.put(cont++, pesquisaCarroDTO.getKilometragemInicial());
            parametros.put(cont++, pesquisaCarroDTO.getKilometragemFinal());
        }

        if(!pesquisaCarroDTO.getMotorizacao().equals(null)){
            sql.append(" AND")
               .append(" motorizacao = :motorizacao ");
            parametros.put(cont++, pesquisaCarroDTO.getMotorizacao());
        }

        if(pesquisaCarroDTO.getLugares() != null){
            sql.append(" AND")
               .append(" lugares = :lugares ");
            parametros.put(cont++, pesquisaCarroDTO.getLugares());
        }

        if(!pesquisaCarroDTO.getEmprestado().equals(null)){
            sql.append(" AND")
               .append(" emprestado = :emprestado ");
            parametros.put(cont++, pesquisaCarroDTO.getEmprestado());
        }

        if(!pesquisaCarroDTO.getTipoCarro().equals(null)){
            sql.append(" AND")
               .append(" tipoCarro = :tipoCarro ");
            parametros.put(cont++, pesquisaCarroDTO.getTipoCarro());
        }

        if (pesquisaCarroDTO.getKilometragemFinal() < pesquisaCarroDTO.getKilometragemInicial()){
            throw new ValidacaoException("Kilometragem informada inválida");
        }

        if(pesquisaCarroDTO.getValorInicial() != null && pesquisaCarroDTO.getValorFinal() != null){
            sql.append(" AND")
               .append(" valor BETWEEN :inicial AND :fim ");
            parametros.put(cont++, pesquisaCarroDTO.getValorInicial());
            parametros.put(cont++, pesquisaCarroDTO.getValorFinal());
        }else if (pesquisaCarroDTO.getValorInicial() != null && pesquisaCarroDTO.getValorFinal() == null){
            BigDecimal valor = new BigDecimal(0);
            sql.append(" AND")
                    .append(" VALOR >= :inicial ");
            parametros.put(cont++, pesquisaCarroDTO.getValorInicial());
            parametros.put(cont++, valor);
        }else if (pesquisaCarroDTO.getValorInicial() == null && pesquisaCarroDTO.getValorFinal() != null) {
            sql.append(" AND")
                    .append(" VALOR <=  :fim ");
            parametros.put(cont++, pesquisaCarroDTO.getValorFinal());
        }

        Query query = entityManager.createQuery(sql.toString());
        for (int i =0; i <= parametros.size(); i++){
            query.setParameter(i, parametros.get(i));
        }

		List<Carro> carros = query.getResultList();
        if(CollectionUtils.isEmpty(carros)) {
        	return null;
        }
        
        return carros;
        
    }
}

