package main.java.service;

import main.java.dto.CarroDTO;
import main.java.dto.PesquisaCarroDTO;
import main.java.entity.Carro;
import main.java.enums.FlagAtivo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import main.java.repository.CarroRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class

CarroService {

	@Autowired
	private CarroRepository carroRepository;

	public CarroDTO insert(CarroDTO carroDTO) {

		try {
			Carro carro = null;
			BeanUtils.copyProperties(carroDTO, carro);
			carro = carroRepository.save(carro);
			carro.ge
			if (carro != null) {
				BeanUtils.copyProperties(carro, carroDTO);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return carroDTO;
	}

	public CarroDTO atualizar(CarroDTO carroDTO) {
		try {
			Long id = carroDTO.getId();
			Carro carro = carroRepository.findById(id);
			if (carro != null) {
				BeanUtils.copyProperties(carroDTO, carro);
				carro = carroRepository.save(carro);
				BeanUtils.copyProperties(carro, carroDTO);
			}

		} catch (Exception e) {
			e.getMessage();
		}

		return carroDTO;
	}

	public CarroDTO inativar(Long id) {

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

	
	public List<CarroDTO> pesquisaCarro(PesquisaCarroDTO pesquisaCarroDTO) {

		Long kilometragemInicial = pesquisaCarroDTO.getKilometragemInicial();
		Long kilometragemFinal = pesquisaCarroDTO.getKilometragemFinal();
		List<CarroDTO> carroDTOS = new ArrayList<>();

		try {
			validaKilometragem(kilometragemInicial, kilometragemFinal);
			List<Carro> carros = carroRepository.pesquisaCarro(pesquisaCarroDTO);
			if (!CollectionUtils.isEmpty(carros)) {
				for (Carro carro : carros) {
					CarroDTO carroDTO = new CarroDTO();
					BeanUtils.copyProperties(carro, carroDTO);
					carroDTOS.add(carroDTO);
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return carroDTOS;
	}

	public CarroDTO pesquisaCarroId(Long id) {

		CarroDTO carroDTO = null;
		try {
			Carro carro = carroRepository.findById(id);
			if (carro != null) {
				BeanUtils.copyProperties(carro, carroDTO);
			}
		} catch (Exception e) {
			e.getMessage();
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
