package repositoryCustom;

import dto.PesquisaCarroDTO;
import entity.Carro;
import exceptions.ValidacaoException;

import java.time.LocalDate;
import java.util.List;

public interface CarroRepositoryCustom {

    List<Carro> findByKmInicialKmFinal(Long kilometragemInicial, Long kilometragemFinal);
    List<Carro> findByDataInicioAndDataFim(LocalDate inicio, LocalDate fim);
    List<Carro> pesquisaCarro(PesquisaCarroDTO pesquisaCarroDTO) throws ValidacaoException;

}
