package com.example.restaurante.caixa;

import org.springframework.stereotype.Service;

@Service
public class CaixaService {

    private final CaixaRepository caixaRepository;

    public CaixaService(CaixaRepository caixaRepository) {
        this.caixaRepository = caixaRepository;
    }

    public double save(double valor) {
        caixaRepository.save(valor);
        return this.read();
    }

    public double read() {
        return caixaRepository.read();
    }
}
