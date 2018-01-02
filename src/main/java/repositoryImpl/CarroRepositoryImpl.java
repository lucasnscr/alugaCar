package repositoryImpl;

import dto.PesquisaCarroDTO;
import entity.Carro;
import org.springframework.beans.factory.annotation.Autowired;
import repositoryCustom.CarroRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
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

	@SuppressWarnings({ "unused", "unchecked" })
	@Override
    public List<Carro> pesquisaCarro(PesquisaCarroDTO pesquisaCarroDTO) {

        StringBuilder sql = new StringBuilder();
        int cont = 0;
        Map<Integer, Object> parametros =  new HashMap<>();

        sql.append(" SELECT * FROM" )
                .append(" WHERE ");

        if(pesquisaCarroDTO.getMarca() != null){
            sql.append("  MARCA = ?");
            parametros.put(cont++, pesquisaCarroDTO.getMarca());
        }

        if(pesquisaCarroDTO.getAno() != null){
            sql.append(" ANO = ?");
            parametros.put(cont++, pesquisaCarroDTO.getAno());
        }

        if(pesquisaCarroDTO.getKilometragemInicial() != null && pesquisaCarroDTO.getKilometragemFinal() != null){
            sql.append(" KILOMETRAGEM BETWEEN ? AND ? ");
            parametros.put(cont++, pesquisaCarroDTO.getKilometragemInicial());
            parametros.put(cont++, pesquisaCarroDTO.getKilometragemFinal());
        }

        if(!pesquisaCarroDTO.getMotorizacao().equals(null)){
            sql.append(" MOTORIZACAO = ?");
            parametros.put(cont++, pesquisaCarroDTO.getMotorizacao());
        }

        if(pesquisaCarroDTO.getLugares() != null){
            sql.append(" LUGARES = ?");
            parametros.put(cont++, pesquisaCarroDTO.getLugares());
        }

        if(!pesquisaCarroDTO.getEmprestado().equals(null)){
            sql.append(" EMPRESTADO = ?");
            parametros.put(cont++, pesquisaCarroDTO.getEmprestado());
        }

        if(!pesquisaCarroDTO.getPrioridade().equals(null)){
            sql.append(" PRIORIDADE = ?");
            parametros.put(cont++, pesquisaCarroDTO.getPrioridade());
        }

        Query query = entityManager.createNativeQuery(sql.toString());
        for (int i =0; i <= parametros.size(); i++){
            query.setParameter(i, parametros.get(i));
        }

        List<Carro> carros = query.getResultList();
        
        return carros;
        
    }
}

