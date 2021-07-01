package com.example.restaurante.caixa;

import org.springframework.stereotype.Repository;

@Repository
public class CaixaRepository {

    private static double valorTotal = 0.0;

    public CaixaRepository() {
    }

    public void save(double valor) {
        valorTotal += valor;
    }

    public double read() {
        return valorTotal;
    }
}
