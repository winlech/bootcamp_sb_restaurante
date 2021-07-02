package com.example.restaurante.Mesa;

import com.example.restaurante.Pedido.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MesaService {

    private final MesaRepository mesaRepository;
    private final PedidoRepository pedidoRepository;


    @Autowired
    public MesaService(MesaRepository mesaRepository, PedidoRepository pedidoRepository) {
        this.mesaRepository = mesaRepository;
        this.pedidoRepository = pedidoRepository;
    }

    public Mesa getMesa(Long id) {
        return mesaRepository.findById(id);
    }


    public MesaPedidoDTO getPedidos(Long id) {
        Mesa mesa = this.mesaRepository.findById(id);

        return new MesaPedidoDTO(mesa.getPedidos(), mesa.getValorTotalConsumido());
    }

    public double fecharPedido(Long id) {
        return mesaRepository.fecharMesa(id);
    }
}
