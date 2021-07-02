package com.example.restaurante.Pedido;

import com.example.restaurante.Mesa.Mesa;
import com.example.restaurante.Mesa.MesaRepository;
import com.example.restaurante.Prato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    private PedidoRepository pedidoRepository;
    private MesaRepository mesaRepository;
    private static Long pedidoId = 1L;

    @Autowired
    public PedidoService(MesaRepository mesaRepository, PedidoRepository pedidoRepository) {
        this.mesaRepository = mesaRepository;
        this.pedidoRepository = pedidoRepository;
    }

//    public Pedido addPedido(PedidoDTO pedidoDto) {
//        double valorTotal = pedidoDto.getPratos()
//                .stream()
//                .mapToDouble(Prato::getPreco)
//                .sum();
//        Pedido pedido = new Pedido(pedidoId++, pedidoDto.getMesaId(), pedidoDto.getPratos(), valorTotal);
//
//        mesaRepository.addPedido(pedido);
//
//        return pedido;
//    }

    public Pedido createPedido(PedidoDTO pedidoDto) {
        double valorTotal = pedidoDto.getPratos()
                .stream()
                .mapToDouble(Prato::getPreco)
                .sum();
        Pedido pedido = new Pedido(pedidoId++, pedidoDto.getMesaId(), pedidoDto.getPratos(), valorTotal);
        pedidoRepository.save(pedido);
        mesaRepository.addPedido(pedido);


        return pedido;
    }

    public Pedido deletePedido(Long pedidoId) {
        Pedido pedido = pedidoRepository.findById(pedidoId);
        mesaRepository.removePedido(pedido);
        return pedidoRepository.removePedidoById(pedidoId);
    }

    public void updatePedido(Pedido pedido) {
        pedidoRepository.update(pedido);
    }
}
