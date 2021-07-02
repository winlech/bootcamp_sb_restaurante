package com.example.restaurante.Mesa;

import com.example.restaurante.Pedido.Pedido;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class MesaRepository {

    private final List<Mesa> mesas;

    public MesaRepository() {
        this.mesas = new ArrayList<>(Arrays.asList(
                new Mesa(1L, 0.0),
                new Mesa(2L, 0.0),
                new Mesa(3L, 0.0),
                new Mesa(4L, 0.0),
                new Mesa(5L, 0.0)
        ));
    }

    public Mesa findById(Long id) {
        return this.mesas.stream()
                .filter(mesa -> mesa.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Pedido addPedido(Pedido pedido) {
        Mesa mesa = this.findById(pedido.getMesa());

        mesa.addPedido(pedido);

        return pedido;
    }

    public MesaRepository(List<Mesa> mesas) {
        this.mesas = mesas;
    }

    public Double fecharMesa(Long id) {
        Mesa mesa = this.findById(id);
        Double valorConta = mesa.getValorTotalConsumido();

        mesa.getPedidos().clear();
        mesa.setValorTotalConsumido(0.0);


        return valorConta;

    }

    public void removePedido(Pedido pedido) {
        Mesa mesa = this.findById(pedido.getMesa());
        Pedido pedidoRm = mesa.getPedidos().stream().filter(p -> pedido.getId().equals(pedido.getId())).findFirst().get();
        mesa.getPedidos().remove(pedidoRm);
    }
}
