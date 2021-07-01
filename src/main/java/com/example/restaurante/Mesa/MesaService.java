package com.example.restaurante.Mesa;

import com.example.restaurante.Pedido.Pedido;
import com.example.restaurante.Pedido.PedidoDTO;
import com.example.restaurante.Prato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MesaService {

    private final MesaRepository mesaRepository;

    @Autowired
    public MesaService(MesaRepository mesaRepository) {
        this.mesaRepository = mesaRepository;
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
