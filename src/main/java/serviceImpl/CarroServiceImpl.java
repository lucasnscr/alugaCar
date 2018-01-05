package serviceImpl;

import dto.CarroDTO;
import dto.PesquisaCarroDTO;
import entity.Carro;
import enums.FlagAtivo;
import exceptions.ServicoException;
import exceptions.ValidacaoException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import MensagensErro.MensagemErro;
import repository.CarroRepository;
import service.CarroService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarroServiceImpl implements CarroService {

	@Autowired
	private CarroRepository carroRepository;

	@Override
	public CarroDTO insert(CarroDTO carroDTO) throws ValidacaoException, ServicoException {
		try {
			Carro carro = null;
			BeanUtils.copyProperties(carroDTO, carro);
			carro = carroRepository.save(carro);
			if (carro != null) {
				BeanUtils.copyProperties(carro, carroDTO);
			}
		} catch (Exception e) {
			throw new ServicoException(MensagemErro.ERRO_AO_INSERIR_CARRO);
			
		}
		return carroDTO;
	}

	@Override
	public CarroDTO atualizar(CarroDTO carroDTO) throws ValidacaoException, ServicoException {
		try {
			Long id = carroDTO.getId();
			Carro carro = carroRepository.findById(id);
			if (carro != null) {
				BeanUtils.copyProperties(carroDTO, carro);
				carro = carroRepository.save(carro);
				BeanUtils.copyProperties(carro, carroDTO);
			}else {
				throw new ValidacaoException(MensagemErro.ERRO_CARRO_NAO_INFORMADO);
			}
		} catch (Exception e) {
			throw new ServicoException(MensagemErro.ERRO_AO_ATUALIZAR_CARRO);
		}
		return carroDTO;
	}

	@Override
	public CarroDTO inativar(Long id) throws ValidacaoException, ServicoException {

		CarroDTO carroDTO = null;
		try {
			Carro carro = carroRepository.findById(id);
			if (carro != null) {
				carro.setAtivo(FlagAtivo.INATIVO);
				carro = carroRepository.save(carro);
			}
			BeanUtils.copyProperties(carro, carroDTO);
		} catch (Exception e) {
			e.getMessage();
		}

		return carroDTO;
	}
	
	@Override
	public List<CarroDTO> pesquisaCarro(PesquisaCarroDTO pesquisaCarroDTO) throws ValidacaoException, ServicoException {
		List<CarroDTO> carroDTOS = new ArrayList<>();
		try {
			validaKilometragem(pesquisaCarroDTO.getKilometragemInicial(), pesquisaCarroDTO.getKilometragemFinal());
			List<Carro> carros = carroRepository.pesquisaCarro(pesquisaCarroDTO);
			if (!CollectionUtils.isEmpty(carros)) {
				for (Carro carro : carros) {
					CarroDTO carroDTO = new CarroDTO();
					BeanUtils.copyProperties(carro, carroDTO);
					carroDTOS.add(carroDTO);
				}
			}else {
				throw new ValidacaoException(MensagemErro.PESQUISA_DE_CARRO_NAO_OBTEVE_RETORNO);
			}
		} catch (Exception e) {
			throw new ServicoException(MensagemErro.ERRO_PESQUISAR_CARRO);
		}
		return carroDTOS;
	}

	@Override
	public CarroDTO pesquisaCarroId(Long id) throws ValidacaoException, ServicoException {

		CarroDTO carroDTO = null;
		try {
			Carro carro = carroRepository.findById(id);
			if (carro != null) {
				BeanUtils.copyProperties(carro, carroDTO);
			}else {
				throw new ValidacaoException(MensagemErro.PESQUISA_DE_CARRO_NAO_OBTEVE_RETORNO);
			}
		} catch (Exception e) {
			throw new ServicoException(MensagemErro.ERRO_PESQUISAR_CARRO);
		}

		return carroDTO;
	}

	private Boolean validaKilometragem(Long kmInicial, Long kmFinal) {
		Boolean valida = true;
		if (kmInicial > kmFinal) {
			valida = false;
		}
		return valida;
	}

}
