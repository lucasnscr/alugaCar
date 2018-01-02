package main.java.repositoryCustom;

import main.java.dto.PesquisaCarroDTO;
import main.java.entity.Carro;

import java.time.LocalDate;
import java.util.List;

public interface CarroRepositoryCustom {

    List<Carro> findByKmInicialKmFinal(Long kilometragemInicial, Long kilometragemFinal);
    List<Carro> findByDataInicioAndDataFim(LocalDate inicio, LocalDate fim);
    List<Carro> pesquisaCarro(PesquisaCarroDTO pesquisaCarroDTO);

}
