package dto;

import enums.Prioridade;

import java.io.Serializable;
import java.time.LocalDate;

public class PesquisaPedidoDTO implements Serializable {

    private Long idPedido;

    private Long idCliente;

    private CarroDTO carroDTO;

    private LocalDate dataInicioEmprestimo;

    private LocalDate dataFimEmprestimo;

    private Prioridade prioridade;

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public CarroDTO getCarroDTO() {
        return carroDTO;
    }

    public void setCarroDTO(CarroDTO carroDTO) {
        this.carroDTO = carroDTO;
    }

    public LocalDate getDataInicioEmprestimo() {
        return dataInicioEmprestimo;
    }

    public void setDataInicioEmprestimo(LocalDate dataInicioEmprestimo) {
        this.dataInicioEmprestimo = dataInicioEmprestimo;
    }

    public LocalDate getDataFimEmprestimo() {
        return dataFimEmprestimo;
    }

    public void setDataFimEmprestimo(LocalDate dataFimEmprestimo) {
        this.dataFimEmprestimo = dataFimEmprestimo;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }
}
