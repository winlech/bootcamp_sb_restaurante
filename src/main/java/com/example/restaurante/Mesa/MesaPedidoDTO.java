package com.example.restaurante.Mesa;

import com.example.restaurante.Pedido.Pedido;

import java.util.List;

public class MesaPedidoDTO {

    private List<Pedido> pedidos;
    private double valorTotal;

    public MesaPedidoDTO(List<Pedido> pedidos, double valorTotal) {
        this.pedidos = pedidos;
        this.valorTotal = valorTotal;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
