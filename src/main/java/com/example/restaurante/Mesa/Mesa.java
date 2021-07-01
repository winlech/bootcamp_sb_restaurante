package com.example.restaurante.Mesa;

import com.example.restaurante.Pedido.Pedido;

import java.util.ArrayList;
import java.util.List;

public class Mesa {

    private Long id;
    private List<Pedido> pedidos;
    private double valorTotalConsumido;

    public Mesa(Long id, double valorTotalConsumido) {
        this.id = id;
        this.pedidos = new ArrayList<>();
        this.valorTotalConsumido = valorTotalConsumido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void addPedido(Pedido pedido) {
        this.pedidos.add(pedido);
        this.valorTotalConsumido += pedido.getValorTotal();
    }

    public double getValorTotalConsumido() {
        return valorTotalConsumido;
    }

    public void setValorTotalConsumido(double valorTotalConsumido) {
        this.valorTotalConsumido = valorTotalConsumido;
    }
}
