package com.example.restaurante.Pedido;

import com.example.restaurante.Mesa.Mesa;
import com.example.restaurante.Prato;

import java.util.List;

public class PedidoDTO {

    private Long mesaId;
    private List<Prato> pratos;

    public PedidoDTO(Long mesaId, List<Prato> pratos) {
        this.mesaId = mesaId;
        this.pratos = pratos;
    }

    public Long getMesaId() {
        return mesaId;
    }

    public void setMesaId(Long mesaId) {
        this.mesaId = mesaId;
    }

    public List<Prato> getPratos() {
        return pratos;
    }

    public void setPratos(List<Prato> pratos) {
        this.pratos = pratos;
    }
}
