package serviceImpl;

import dto.CarroDTO;
import dto.PedidoDTO;
import dto.PesquisaPedidoDTO;
import entity.Carro;
import entity.Pedido;
import enums.FlagAtivo;
import exceptions.ServicoException;
import exceptions.ValidacaoException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CarroRepository;
import repository.PedidoRepository;
import service.PedidoService;

import java.time.LocalDate;
import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private CarroRepository carroRepository;

    @Override
    public PedidoDTO insert(PedidoDTO pedidoDTO) throws ValidacaoException, ServicoException {
        Pedido pedido =  null;
        Boolean disponibilidade = false;

        try{
            if(pedidoDTO != null){
                BeanUtils.copyProperties(pedidoDTO, pedido);
            }
            CarroDTO carroDTO = pedidoDTO.getCarroDTO();
            disponibilidade = carroDisponivel(carroDTO.getId(), pedidoDTO.getDataInicioEmprestimo(), pedidoDTO.getDataFimEmprestimo());
            if(pedido != null && disponibilidade ==  true){
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
            Pedido pedido = pedidoRepository.findById(id);
            if(pedido != null){
                pedido.setAtivo(FlagAtivo.INATIVO);
                pedidoRepository.save(pedido);
                Long idPedidoInativado = pedido.getId();
                BeanUtils.copyProperties(pedidoDTO, pedido);
                pedido.setIdPedidoAtualizado(idPedidoInativado);
                pedido = pedidoRepository.save(pedido);
                BeanUtils.copyProperties(pedido, pedidoDTO);
            }
        }catch (Exception e){
            throw  new ValidacaoException("Erro ao alterar pedido");
        }
        return pedidoDTO;
    }

    @Override
    public PedidoDTO cancelar(Long id) throws ValidacaoException, ServicoException {
        return null;
    }

    @Override
    public List<PedidoDTO> pesquisaPedido(PesquisaPedidoDTO pedidoDTO) throws ValidacaoException, ServicoException {
        return null;
    }

    @Override
    public PedidoDTO pesquisaPorId(Long id) throws ValidacaoException, ServicoException {
        return null;
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
            throw new ValidacaoException("Erro na verificação de disponibilidade do carro");
        }
        return disponibilidade;
    }

}
