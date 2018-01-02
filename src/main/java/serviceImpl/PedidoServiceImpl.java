package serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import main.java.repository.PedidoRepository;

@Service
public class PedidoServiceImpl {

    @Autowired
    private PedidoRepository pedidoRepository;


}
