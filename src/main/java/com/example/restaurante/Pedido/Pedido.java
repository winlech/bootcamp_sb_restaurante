package com.example.restaurante.Pedido;

import com.example.restaurante.Prato;

import java.util.List;

public class Pedido {

    private Long id;
    private Long mesaId;
    private List<Prato> pratos;
    private double valorTotal;

    public Pedido(Long id, Long mesaId, List<Prato> pratos, double valorTotal) {
        this.id = id;
        this.mesaId = mesaId;
        this.pratos = pratos;
        this.valorTotal = valorTotal;
    }

    public Pedido() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMesa() {
        return mesaId;
    }

    public void setMesa(Long mesaId) {
        this.mesaId = mesaId;
    }

    public List<Prato> getPratos() {
        return pratos;
    }

    public void setPratos(List<Prato> pratos) {
        this.pratos = pratos;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
