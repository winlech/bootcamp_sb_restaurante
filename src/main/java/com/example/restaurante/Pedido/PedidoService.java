package com.example.restaurante.Pedido;

import com.example.restaurante.Mesa.Mesa;
import com.example.restaurante.Mesa.MesaRepository;
import com.example.restaurante.Prato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    private MesaRepository mesaRepository;
    private static Long pedidoId = 1L;

    @Autowired
    public PedidoService(MesaRepository mesaRepository) {
        this.mesaRepository = mesaRepository;
    }

    public Pedido addPedido(PedidoDTO pedidoDto) {
        double valorTotal = pedidoDto.getPratos()
                .stream()
                .mapToDouble(Prato::getPreco)
                .sum();
        Pedido pedido = new Pedido(pedidoId++, pedidoDto.getMesaId(), pedidoDto.getPratos(), valorTotal);

        mesaRepository.addPedido(pedido);

        return pedido;
    }
}
